package coding.work.station.gpos.data.network.responses

import coding.work.station.gpos.data.db.entities.Quote

data class QuotesResponse(
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)