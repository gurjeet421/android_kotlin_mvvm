package coding.work.station.gpos.data.db

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import coding.work.station.gpos.data.db.entities.Quote

interface QuoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllQuotes(quote: List<Quote>)

    @Query("SELECT * FROM Quote")
    fun getQuotes(): LiveData<List<Quote>>
}