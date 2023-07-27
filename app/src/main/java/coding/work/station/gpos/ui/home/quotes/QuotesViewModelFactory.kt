package coding.work.station.gpos.ui.home.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import coding.work.station.gpos.data.network.repositories.QuotesRepository
import coding.work.station.gpos.data.network.repositories.UserRepository

@Suppress("UNCHECKED_CAST")
class QuotesViewModelFactory(private val repository: QuotesRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuotesViewModelFactory(repository) as T
    }

}