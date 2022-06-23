package com.brainstation23.topandroidrepositories.data.database.repository.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
data class User(
    @PrimaryKey @Expose @SerializedName("id")
    @ColumnInfo(name = "id") var id: Int? = null,

    @Expose @SerializedName("name")
    @ColumnInfo(name = "name") var name: String? = null
)