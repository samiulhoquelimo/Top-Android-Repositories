package com.brainstation23.topandroidrepositories.data.database.repository.git_repository

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "git_repository")
data class GitRepository(
    @PrimaryKey var id: Int? = null,
    @ColumnInfo(name = "name") var name: String? = null,
    @ColumnInfo(name = "description") var description: String? = null,
    @ColumnInfo(name = "date") var date: String? = null,
    @ColumnInfo(name = "image") var image: String? = null,
    @ColumnInfo(name = "star") var star: Int? = null
)