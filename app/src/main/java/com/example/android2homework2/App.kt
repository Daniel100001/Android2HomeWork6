package com.example.android2homework2

import android.app.Application
import com.example.android2homework2.utils.PreferenceHelper

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val preferenceHelper = PreferenceHelper()
        preferenceHelper.unit(this)
    }
}