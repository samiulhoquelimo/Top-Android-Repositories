package com.brainstation23.topandroidrepositories.data.database.repository.user

import io.reactivex.Observable
import javax.inject.Inject

class UserRepository @Inject constructor(private val dao: UserDao) : UserRepo {

    override fun insert(model: User): Observable<Boolean> {
        dao.delete()
        dao.insert(model)
        return Observable.just(dao.count() > 0)
    }

    override fun loadByUserId(userId: Int): Observable<User> =
        Observable.fromCallable { dao.loadById(userId) }

    override fun delete(): Observable<Boolean> {
        dao.delete()
        return Observable.just(dao.count() == 0)
    }

    override fun isEmpty(): Observable<Boolean> = Observable.just(dao.count() == 0)
}