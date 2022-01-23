package hd.base.android.domains.auth

import android.util.Log
import androidx.lifecycle.MutableLiveData
import hd.base.android.base.BaseViewModel

/**
 * Create on 22/01/2022
 * @author duonghd
 */

class AuthViewModel : BaseViewModel() {
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
    }

    fun signUp(username: String, password: String) {
        Log.e(TAG, "signUp ~> $username $password")
    }
}