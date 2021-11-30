package co.mvvm.sample.android.session

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class Session @Inject constructor(@ApplicationContext context: Context) {
    /*must create masterKey alias*/
    private val masterKeyAlias = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build()

    /*Encrypted sharedPreferences using Master key with scheme AES256_GCM Bit */
    private val sharedPreferences: SharedPreferences by lazy {
        EncryptedSharedPreferences.create(
            context,
            "${context.packageName} session",
            masterKeyAlias,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    private val editPref: SharedPreferences.Editor by lazy {
        sharedPreferences.edit()
    }


    fun <T> save(key: String, value: T?) {
        when (value) {
            is String -> {
                editPref.putString(key, value)
            }

            is Float -> {
                editPref.putFloat(key, value)
            }

            is Long -> {
                editPref.putLong(key, value)
            }

            is Boolean -> {
                editPref.putBoolean(key, value)
            }

            is Int -> {
                editPref.putInt(key, value)
            }

            else -> {
                throw RuntimeException("Attempting to save non-primitive preference")
            }
        }

        editPref.commit()
    }

    fun <T> getPref(key: String, default: T): T {
        val value = sharedPreferences.all[key] as T?
        return value ?: default
    }

    fun clearPref() {
        editPref.clear()
        editPref.apply()
    }

    fun remove(key: String): Boolean {
        if (sharedPreferences.contains(key)) {
            editPref.remove(key).commit()
            return true
        }
        return false
    }
}