package com.brainstation23.topandroidrepositories.data.database.repository.git_repository

import io.reactivex.Observable

interface GitRepositoryRepo {

    fun insert(data: List<GitRepository>): Observable<Boolean>

    fun load(): Observable<List<GitRepository>>

    fun loadById(id: Int): Observable<GitRepository>

    fun delete(): Observable<Boolean>

    fun isEmpty(): Observable<Boolean>

    fun isNotEmpty(): Observable<Boolean>
}