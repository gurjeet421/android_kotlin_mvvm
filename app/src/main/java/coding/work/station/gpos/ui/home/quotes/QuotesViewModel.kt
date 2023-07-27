package coding.work.station.gpos.ui.home.quotes

import androidx.lifecycle.ViewModel
import coding.work.station.gpos.data.network.repositories.QuotesRepository
import coding.work.station.gpos.util.lazyDeferred

class QuotesViewModel(quotesRepository: QuotesRepository) : ViewModel() {
    val quotes by lazyDeferred {
        quotesRepository.getQuotes()
    }
}