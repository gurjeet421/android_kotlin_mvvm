package coding.work.station.gpos.ui.auth

import androidx.lifecycle.ViewModel
import coding.work.station.gpos.data.db.entities.User
import coding.work.station.gpos.data.network.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthViewModel(private val repository: UserRepository) : ViewModel() {

    fun getLoggedInUser() = repository.getUser()

    suspend fun userLogin(email: String, password: String) =
        withContext(Dispatchers.IO) { repository.userLogin(email, password) }

    suspend fun userSIgnUp(name: String, email: String, password: String) =
        withContext(Dispatchers.IO) { repository.userSignUp(name, email, password) }

    suspend fun saveLoggedInUser(user: User) = repository.saveUser(user)


}