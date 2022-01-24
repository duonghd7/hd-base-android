package hd.base.core.di

import android.content.Context
import hd.base.core.preference.PreferenceImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Create on 24/01/2022
 * @author duonghd
 */

object AppModule {

    fun init(sharedPreferenceName: String): Module {

        return module {

            single { androidApplication().getSharedPreferences(sharedPreferenceName, Context.MODE_PRIVATE) }

            single { PreferenceImpl(get()) }
        }
    }
}

