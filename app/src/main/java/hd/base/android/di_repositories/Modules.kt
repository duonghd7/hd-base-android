package hd.base.android.di_repositories

import android.content.Context
import hd.base.android.domains.auth.AuthViewModel
import hd.base.android.domains.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Create on 24/01/2022
 * @author duonghd
 */

object Modules {

    object RepoModule {
        fun init(context: Context): Module {
            return module {
                single { AuthRepository(context = context, get()) }
            }
        }
    }

    object ViewModelModule {
        fun init(): Module {
            return module {
                viewModel { MainViewModel(get()) }
                viewModel { AuthViewModel(get()) }
            }
        }
    }
}