package hd.base.android.domains.auth

import android.util.Log
import androidx.lifecycle.MutableLiveData
import hd.base.android.base.BaseViewModel
import hd.base.android.di_repositories.AuthRepository
import hd.base.android.services.auth.request.RequestLogin
import kotlinx.coroutines.launch

/**
 * Create on 22/01/2022
 * @author duonghd
 */

class AuthViewModel(
    private val authRepository: AuthRepository,
) : BaseViewModel() {
    companion object {
        private val TAG = AuthViewModel::class.simpleName ?: ""
    }

    val toSignIn = MutableLiveData<Boolean>()
    val toSignUp = MutableLiveData<Boolean>()

    init {
        Log.e(TAG, "init")
    }

    fun signIn(username: String, password: String) {
        Log.e(TAG, "signIn ~> $username $password")
        ioScope.launch {
            val response = authRepository.login(RequestLogin(username = username, password = password))
            Log.e(TAG, "signIn:response ~> $response")
        }
    }

    fun signUp(username: String, password: String) {
        Log.e(TAG, "signUp ~> $username $password")
        ioScope.launch {
            val response = authRepository.me()
            Log.e(TAG, "signIn:signUp ~> $response")
        }
    }
}