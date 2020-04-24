package com.falc.daynightthemedemo

import android.content.Context

class SharedPreferencesManager(private val context : Context) {

    fun saveThemeMode(themeCode : Int) {
        val editor = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE).edit()
        editor.putInt(THEME_CODE_KEY, themeCode)
        editor.apply()
    }

    fun getSavedThemeMode() : Int {
        return context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE).getInt(THEME_CODE_KEY, 1)
    }

    companion object {
        private const val SHARED_PREFS = "shared preferences"
        private const val THEME_CODE_KEY = "is dark key"
    }
}