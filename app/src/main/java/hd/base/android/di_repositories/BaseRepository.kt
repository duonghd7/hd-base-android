package hd.base.android.di_repositories

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import hd.base.android.R
import hd.base.android.services.ApiResponse
import hd.base.core.network.DNetwork
import retrofit2.Response

/**
 * Create on 24/01/2022
 * @author duonghd
 */

open class BaseRepository(private val context: Context) {

    suspend fun <T : Any> makeApiCall(call: suspend () -> Response<ApiResponse<T>>): ApiResponse<T> {
        if (!DNetwork.isInternetAvailable(context = context)) {
            return ApiResponse.apiError(
                message = context.getString(R.string.no_internet_connection)
            )
        }

        return try {
            val response = call.invoke()
            if (response.isSuccessful && response.body()?.data != null) {
                response.body() as ApiResponse<T>
            } else {
                handleError(response)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            ApiResponse.apiError(message = e.localizedMessage ?: e.message)
        }
    }

    private fun <T : Any> handleError(response: Response<ApiResponse<T>>?): ApiResponse<T> {
        var errorResponse: ApiResponse<T>? = null
        response?.errorBody()?.let {
            try {
                val gson = Gson()
                val collectionType = object : TypeToken<ApiResponse<T>>() {}.type
                errorResponse = gson.fromJson(it.string(), collectionType)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        return ApiResponse.apiError(
            message = errorResponse?.message,
        )
    }
}