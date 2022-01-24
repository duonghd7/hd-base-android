package hd.base.android.di_repositories

import android.content.Context
import hd.base.android.services.auth.AuthService
import hd.base.android.services.auth.request.RequestLogin

/**
 * Create on 24/01/2022
 * @author duonghd
 */

class AuthRepository(
    context: Context,
    private val authService: AuthService
) : BaseRepository(context = context) {
    suspend fun login(requestLogin: RequestLogin) = makeApiCall(
        call = { authService.login(requestLogin) }
    )

    suspend fun me() = makeApiCall(
        call = { authService.me() }
    )
}