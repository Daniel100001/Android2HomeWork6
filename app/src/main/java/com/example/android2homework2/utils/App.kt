package com.example.android2homework2.utils

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val preferenceHelper = PreferenceHelper()
        preferenceHelper.unit(this)
    }
}