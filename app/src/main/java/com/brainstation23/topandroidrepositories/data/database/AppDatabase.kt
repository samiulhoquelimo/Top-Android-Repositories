package com.brainstation23.topandroidrepositories.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.brainstation23.topandroidrepositories.data.database.adapter.AppDatabaseConverters
import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepository
import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepositoryDao
import com.brainstation23.topandroidrepositories.utils.AppConstants

@Database(
    entities = [GitRepository::class],
    version = AppConstants.VERSION_CODE,
    exportSchema = false
)
@TypeConverters(AppDatabaseConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun gitRepositoryDao(): GitRepositoryDao
}