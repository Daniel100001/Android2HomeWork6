package com.example.android2homework2.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {

    private var sharedPreference : SharedPreferences? = null

    fun unit(context: Context){
        sharedPreference = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    }

    fun onSaveOnBoardState(){
        sharedPreference!!.edit().putBoolean("isShown",true).apply()
    }
    fun isShown(): Boolean{
        return sharedPreference!!.getBoolean("isShown", false)
    }
}