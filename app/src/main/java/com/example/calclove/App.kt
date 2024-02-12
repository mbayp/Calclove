package com.example.calclove

import android.app.Application
import androidx.room.Room
import com.example.calclove.room.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {
        lateinit var appDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "love-db")
            .allowMainThreadQueries().build()
    }
}