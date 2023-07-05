package com.example.android2homework2

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.android2homework2.ui.data.db.AppDatabase
import com.example.android2homework2.utils.PreferenceHelper

class App : Application() {

    companion object {
        private var appDatabase: AppDatabase? = null
        @SuppressLint("StaticFieldLeak")
        private var context: Context? = null

        fun getInstate(): AppDatabase? {
            if (appDatabase == null) {
                appDatabase = context?.let {
                    Room.databaseBuilder(
                        it,
                        AppDatabase::class.java,
                        name = "note.database"
                    ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
                }
            }
            return appDatabase
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        val preferenceHelper = PreferenceHelper()
        preferenceHelper.unit(this)
        getInstate()
    }
}