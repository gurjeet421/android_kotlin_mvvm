package coding.work.station.gpos.data.prefrences

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

class PreferenceProvider(context: Context) {

    private val appContext = context.applicationContext

    private val preference: SharedPreferences
        get() = PreferenceManager.getDefaultSharedPreferences(appContext)

    fun saveLastSavedAt(savedAt: String) {
        preference.edit().putString("key", savedAt).apply()
    }

    fun getLastSavedAt(): String? {
        return preference.getString("key", "")
    }
}