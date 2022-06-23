package com.brainstation23.topandroidrepositories.data.database.repository.git_repository

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "git_repository")
data class GitRepository(
    @PrimaryKey @Expose @SerializedName("id")
    @ColumnInfo(name = "id") var id: Int? = null,

    @Expose @SerializedName("name")
    @ColumnInfo(name = "name") var name: String? = null,

    @Expose @SerializedName("description")
    @ColumnInfo(name = "description") var description: String? = null,

    @Expose @SerializedName("date")
    @ColumnInfo(name = "date") var date: String? = null,

    @Expose @SerializedName("image")
    @ColumnInfo(name = "image") var image: String? = null,

    @Expose @SerializedName("star")
    @ColumnInfo(name = "star") var star: Int? = null

)