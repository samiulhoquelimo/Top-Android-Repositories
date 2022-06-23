package com.brainstation23.topandroidrepositories.data.database.repository.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun load(): List<User>

    @Query("SELECT * FROM user WHERE id=:id limit 1")
    fun loadById(id: Int): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(model: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(list: List<User>)

    @Query("DELETE FROM user")
    fun delete()

    @Query("SELECT COUNT(*) FROM user")
    fun count(): Int

}