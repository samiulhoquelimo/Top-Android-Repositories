package com.brainstation23.topandroidrepositories.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.brainstation23.topandroidrepositories.data.database.repository.user.User
import com.brainstation23.topandroidrepositories.data.database.repository.user.UserDao
import com.brainstation23.topandroidrepositories.utils.AppConstants

@Database(
    entities = [
        User::class,
    ],
    version = AppConstants.VERSION_CODE,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}