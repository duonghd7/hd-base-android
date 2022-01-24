package hd.base.android.services.auth.response

import android.os.Parcelable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Create on 23/01/2022
 * @author duonghd
 */

@Parcelize
data class ResponseUser(
    @SerializedName("_id")
    val id: String? = null,

    @SerializedName("username")
    val username: String? = null,

    @SerializedName("balance")
    val balance: String? = null,

    @SerializedName("accessToken")
    val accessToken: String? = null

) : Parcelable {
    override fun toString(): String {
        return Gson().toJson(this)
    }
}