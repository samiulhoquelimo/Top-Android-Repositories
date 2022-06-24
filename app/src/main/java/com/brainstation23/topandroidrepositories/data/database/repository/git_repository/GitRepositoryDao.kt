package com.brainstation23.topandroidrepositories.data.database.repository.git_repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GitRepositoryDao {

    @Query("SELECT * FROM git_repository")
    fun load(): List<GitRepository>

    @Query("SELECT * FROM git_repository ORDER BY date ASC")
    fun loadSortByDateAsc(): List<GitRepository>

    @Query("SELECT * FROM git_repository ORDER BY date DESC")
    fun loadSortByDateDesc(): List<GitRepository>

    @Query("SELECT * FROM git_repository ORDER BY star ASC")
    fun loadSortByStarAsc(): List<GitRepository>

    @Query("SELECT * FROM git_repository ORDER BY star DESC")
    fun loadSortByStarDesc(): List<GitRepository>

    @Query("SELECT * FROM git_repository WHERE id=:id limit 1")
    fun loadById(id: Int): GitRepository?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(model: GitRepository)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(list: List<GitRepository>)

    @Query("DELETE FROM git_repository")
    fun delete()

    @Query("SELECT COUNT(*) FROM git_repository")
    fun count(): Int

}