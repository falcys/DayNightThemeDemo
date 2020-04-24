package com.falc.daynightthemedemo

import androidx.appcompat.app.AppCompatDelegate

class DayNightThemeManager(private val prefsManager : SharedPreferencesManager) {
    private var currentThemeCode : Int

    init {
        currentThemeCode = prefsManager.getSavedThemeMode()
        AppCompatDelegate.setDefaultNightMode(currentThemeCode)
    }

    fun setTheme(isDark : Boolean) {
        currentThemeCode = if (isDark) AppCompatDelegate.MODE_NIGHT_YES
        else AppCompatDelegate.MODE_NIGHT_NO
        AppCompatDelegate.setDefaultNightMode(currentThemeCode)
        prefsManager.saveThemeMode(currentThemeCode)
    }

    fun getTheme() : Boolean {
        return currentThemeCode == AppCompatDelegate.MODE_NIGHT_YES
    }
}