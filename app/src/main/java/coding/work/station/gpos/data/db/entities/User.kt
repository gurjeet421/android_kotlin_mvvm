package coding.work.station.gpos.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0

@Entity
class User(
    var id: Int? = null,
    var name: String? = null,
    var email: String? = null,
    var password: String? = null,
) {
    @PrimaryKey(autoGenerate = false)
    var uid: Int  = CURRENT_USER_ID
}