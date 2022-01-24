package hd.base.android.services.auth

import hd.base.android.services.ApiResponse
import hd.base.android.services.Config
import hd.base.android.services.auth.request.RequestLogin
import hd.base.android.services.auth.response.ResponseUser
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

/**
 * Create on 23/01/2022
 * @author duonghd
 */

interface AuthService {

    @POST("v1/auth/login")
    suspend fun login(
        @Body loginRequest: RequestLogin
    ): Response<ApiResponse<ResponseUser>>

    @GET("v1/auth/me")
    suspend fun me(
        @Header("Authorization") token: String = Config.AccessToken
    ): Response<ApiResponse<ResponseUser>>
}