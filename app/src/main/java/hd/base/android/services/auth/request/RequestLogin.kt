package hd.base.android.services.auth.request

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

/**
 * Create on 23/01/2022
 * @author duonghd
 */

class RequestLogin(
    @SerializedName("username") private val username: String,
    @SerializedName("password") private val password: String
) {
    override fun toString(): String {
        return Gson().toJson(this);
    }
}