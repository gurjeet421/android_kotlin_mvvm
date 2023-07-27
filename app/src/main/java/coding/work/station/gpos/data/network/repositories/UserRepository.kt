package coding.work.station.gpos.data.network.repositories

import coding.work.station.gpos.data.db.AppDatabase
import coding.work.station.gpos.data.db.entities.User
import coding.work.station.gpos.data.network.MyApi
import coding.work.station.gpos.data.network.SafeApiRequest
import coding.work.station.gpos.data.network.responses.AuthResponse

class UserRepository(private val api: MyApi, private val db: AppDatabase) : SafeApiRequest() {
    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)
    suspend fun userSignUp(
        name: String,
        email: String,
        password: String,
    ): AuthResponse {
        return apiRequest {
            api.userSignUp(name, email, password)
        }
    }

    fun getUser() = db.getUserDao().getUser()
}