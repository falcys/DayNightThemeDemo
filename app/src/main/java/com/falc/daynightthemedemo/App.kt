package com.falc.daynightthemedemo

import android.app.Application

class App : Application() {
    lateinit var themeManager: DayNightThemeManager

    override fun onCreate() {
        super.onCreate()
        instance = this

        val manager = SharedPreferencesManager(this)
       themeManager = DayNightThemeManager(manager)
    }



    companion object {
        var instance : App? = null
    }
}