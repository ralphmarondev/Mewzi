package com.ralphmarondev.mewzi.core.data.local.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class AppPreferences(
    context: Context
) {
    companion object {
        private const val PREFERENCES_NAME = "mewzi_preferences"
        private const val FIRST_LAUNCH = "first_launch"
        private const val DARK_THEME = "dark_theme"
        private const val IP_ADDRESS = "ip_address"
        private const val ACCESS_TOKEN = "access_token"
        private const val REFRESH_TOKEN = "refresh_token"
        private const val USERNAME = "username"
        private const val PASSWORD = "password"
    }

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        PREFERENCES_NAME, Context.MODE_PRIVATE
    )

    fun isFirstLaunch(): Boolean {
        return sharedPreferences.getBoolean(FIRST_LAUNCH, true)
    }

    fun setFirstLaunch(value: Boolean = false) {
        sharedPreferences.edit { putBoolean(FIRST_LAUNCH, value) }
    }

    fun isDarkTheme(): Boolean {
        return sharedPreferences.getBoolean(DARK_THEME, false)
    }

    fun setDarkTheme(value: Boolean = !isDarkTheme()) {
        sharedPreferences.edit { putBoolean(DARK_THEME, value) }
    }

    fun setIpAdress(value: String) {
        sharedPreferences.edit { putString(IP_ADDRESS, value) }
    }

    fun getIpAddress(): String? {
        return sharedPreferences.getString(IP_ADDRESS, null)
    }

    fun setAccessToken(value: String) {
        sharedPreferences.edit { putString(ACCESS_TOKEN, value) }
    }

    fun getAccessToken(): String? {
        return sharedPreferences.getString(ACCESS_TOKEN, null)
    }

    fun setRefreshToken(value: String) {
        sharedPreferences.edit { putString(REFRESH_TOKEN, value) }
    }

    fun getRefreshToken(): String? {
        return sharedPreferences.getString(REFRESH_TOKEN, null)
    }

    fun setUsername(value: String) {
        sharedPreferences.edit { putString(USERNAME, value) }
    }

    fun getUsername(): String? {
        return sharedPreferences.getString(USERNAME, null)
    }

    fun setPassword(value: String) {
        sharedPreferences.edit { putString(PASSWORD, value) }
    }

    fun getPassword(): String? {
        return sharedPreferences.getString(PASSWORD, null)
    }
}