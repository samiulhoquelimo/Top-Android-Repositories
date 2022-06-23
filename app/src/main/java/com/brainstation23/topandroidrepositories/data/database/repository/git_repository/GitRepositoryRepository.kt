package com.brainstation23.topandroidrepositories.data.database.repository.git_repository

import io.reactivex.Observable
import javax.inject.Inject

class GitRepositoryRepository @Inject constructor(private val dao: GitRepositoryDao) :
    GitRepositoryRepo {

    override fun insert(data: List<GitRepository>): Observable<Boolean> {
        dao.delete()
        dao.insert(data)
        return Observable.just(dao.count() > 0)
    }

    override fun load(): Observable<List<GitRepository>> = Observable.fromCallable { dao.load() }

    override fun loadById(id: Int): Observable<GitRepository> =
        Observable.fromCallable { dao.loadById(id) }

    override fun delete(): Observable<Boolean> {
        dao.delete()
        return Observable.just(dao.count() == 0)
    }

    override fun isEmpty(): Observable<Boolean> = Observable.just(dao.count() == 0)

    override fun isNotEmpty(): Observable<Boolean> = Observable.just(dao.count() != 0)
}