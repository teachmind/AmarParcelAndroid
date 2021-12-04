package com.makrosh.amarparcelandroid.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.makrosh.amarparcelandroid.data.model.Users

@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getUsersDao(): UserDao
}