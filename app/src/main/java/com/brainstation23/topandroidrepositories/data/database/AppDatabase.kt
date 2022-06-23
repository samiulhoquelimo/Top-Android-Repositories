package com.brainstation23.topandroidrepositories.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepository
import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepositoryDao
import com.brainstation23.topandroidrepositories.utils.AppConstants

@Database(
    entities = [GitRepository::class],
    version = AppConstants.VERSION_CODE,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun gitRepositoryDao(): GitRepositoryDao
}