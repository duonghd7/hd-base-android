package hd.base.core.preference

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Create on 24/01/2022
 * @author duonghd
 */

class PreferenceImpl constructor(
    private val sharedPreferences: SharedPreferences
) {

    companion object {
        lateinit var instance: PreferenceImpl
    }

    private inline fun <reified T : Any> put(key: String, t: T?) {
        sharedPreferences.edit().apply {
            when (t) {
                is Boolean -> putBoolean(key, t)
                is String -> putString(key, t)
                is Float -> putFloat(key, t)
                is Int -> putInt(key, t)
                is Long -> putLong(key, t)
                else -> putString(key, t.toString())
            }.apply()
        }
    }

    @Suppress("IMPLICIT_CAST_TO_ANY")
    private inline fun <reified T : Any> get(key: String, default: T?): T? =
        sharedPreferences.let {
            when (default) {
                is Boolean -> it.getBoolean(key, default)
                is String -> it.getString(key, default)
                is Float -> it.getFloat(key, default)
                is Int -> it.getInt(key, default)
                is Long -> it.getLong(key, default)
                else -> it.getString(key, null)?.let { json ->
                    val collectionType = object : TypeToken<T>() {}.type
                    Gson().fromJson(json, collectionType)
                } ?: run {
                    null
                }
            } as T?
        }

    fun clear() = sharedPreferences.edit().clear().commit()

    var keyStorage1: String?
        get() = get("keyStorage1", "")
        set(value) = put("keyStorage1", value)

    var keyStorage2: Int?
        get() = get("keyStorage2", 0)
        set(value) = put("keyStorage2", value)
}