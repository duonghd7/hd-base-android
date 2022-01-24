package hd.base.android

import android.app.Application
import hd.base.android.di_repositories.Modules
import hd.base.android.services.auth.AuthService
import hd.base.core.di.AppModule
import hd.base.core.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Create on 22/01/2022
 * @author duonghd
 */


class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()

        BuildConfig.VERSION_NAME
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.NONE)
            androidContext(applicationContext)
            modules(
                listOf(
                    AppModule.init(
                        sharedPreferenceName = BuildConfig.APPLICATION_ID
                    ),
                    NetworkModule.init(
                        isDebug = BuildConfig.DEBUG,
                        timeOut = 60,
                        baseUrl = BuildConfig.API_URL,
                        services = mutableListOf(
                            AuthService::class.java
                        )
                    ),
                    Modules.RepoModule.init(applicationContext),
                    Modules.ViewModelModule.init()
                )
            )
        }
    }
}