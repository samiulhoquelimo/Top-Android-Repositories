package com.brainstation23.topandroidrepositories.data.database.repository.user

import io.reactivex.Observable

interface UserRepo {

    fun insert(model: User): Observable<Boolean>

    fun loadByUserId(userId: Int): Observable<User>

    fun delete(): Observable<Boolean>

    fun isEmpty(): Observable<Boolean>
}