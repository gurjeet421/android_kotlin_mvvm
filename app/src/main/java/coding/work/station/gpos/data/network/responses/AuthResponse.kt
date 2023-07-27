package coding.work.station.gpos.data.network.responses

import coding.work.station.gpos.data.db.entities.User

data class AuthResponse(
    val isSuccessful : Boolean?,
    val message : String?,
    val user : User?
)