package coding.work.station.gpos.ui.home.profile

import androidx.lifecycle.ViewModel
import coding.work.station.gpos.data.network.repositories.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {
    val user = repository.getUser()
}