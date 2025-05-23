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
}