package coding.work.station.gpos

import android.app.Application
import coding.work.station.gpos.data.db.AppDatabase
import coding.work.station.gpos.data.network.MyApi
import coding.work.station.gpos.data.network.NetworkConnectionInterceptor
import coding.work.station.gpos.data.network.repositories.QuotesRepository
import coding.work.station.gpos.data.network.repositories.UserRepository
import coding.work.station.gpos.data.prefrences.PreferenceProvider
import coding.work.station.gpos.ui.auth.AuthViewModelFactory
import coding.work.station.gpos.ui.home.profile.ProfileViewModelFactory
import coding.work.station.gpos.ui.home.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MyApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MyApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { PreferenceProvider(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider { QuotesViewModelFactory(instance()) }
        bind() from provider { QuotesRepository(instance(), instance(), instance()) }
    }
}