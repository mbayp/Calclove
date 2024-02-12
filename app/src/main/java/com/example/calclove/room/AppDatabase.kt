package com.example.calclove.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.calclove.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)

abstract class AppDatabase : RoomDatabase() {
    abstract fun LoveDao(): LoveDao
}