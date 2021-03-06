package com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.interactor

import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepository
import com.brainstation23.topandroidrepositories.data.network.response.model.Item
import com.brainstation23.topandroidrepositories.ui.base.interactor.MVPInteractor
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view.model.SortType
import io.reactivex.Observable

interface HomeFragmentMVPInteractor : MVPInteractor {

    fun seedGitRepository(data: List<Item>?): Observable<Boolean>

    fun fetchGitRepository(): Observable<List<GitRepository>>

    fun fetchDateAsc(): Observable<List<GitRepository>>

    fun fetchDateDesc(): Observable<List<GitRepository>>

    fun fetchStarAsc(): Observable<List<GitRepository>>

    fun fetchStarDesc(): Observable<List<GitRepository>>

    fun getSortType(): SortType

    fun setSortType(type: SortType)
}