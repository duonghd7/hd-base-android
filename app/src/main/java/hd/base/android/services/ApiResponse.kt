package hd.base.android.services

import android.os.Parcelable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

/**
 * Create on 24/01/2022
 * @author duonghd
 */

@Parcelize
data class ApiResponse<T>(
    @SerializedName("data")
    val data: @RawValue T? = null,

    @SerializedName("message")
    val message: String? = null,

    @SerializedName("errorCode")
    val errorCode: String? = null

) : Parcelable {

    companion object {
        fun <T> apiError(message: String?) =
            ApiResponse<T>(
                data = null,
                message = message,
                errorCode = null
            )
    }

    override fun toString(): String {
        return Gson().toJson(this)
    }
}
