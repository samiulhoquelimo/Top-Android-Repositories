package com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.interactor

import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepository
import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepositoryRepo
import com.brainstation23.topandroidrepositories.data.network.ApiHelper
import com.brainstation23.topandroidrepositories.data.network.response.model.Item
import com.brainstation23.topandroidrepositories.data.preferences.PreferenceHelper
import com.brainstation23.topandroidrepositories.ui.base.interactor.BaseInteractor
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view.model.SortType
import com.brainstation23.topandroidrepositories.utils.extension.mapList
import io.reactivex.Observable
import javax.inject.Inject

class HomeFragmentInteractor @Inject constructor(
    private val gitRepositoryRepo: GitRepositoryRepo,

    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) : BaseInteractor(preferenceHelper, apiHelper), HomeFragmentMVPInteractor {

    override fun seedGitRepository(data: List<Item>?): Observable<Boolean> = when (data) {
        null -> Observable.just(false)
        else -> gitRepositoryRepo.insert(data.mapList())
    }

    override fun fetchGitRepository(): Observable<List<GitRepository>> = gitRepositoryRepo.load()

    override fun fetchDateAsc(): Observable<List<GitRepository>> =
        gitRepositoryRepo.loadSortByDateAsc()

    override fun fetchDateDesc(): Observable<List<GitRepository>> =
        gitRepositoryRepo.loadSortByDateDesc()

    override fun fetchStarAsc(): Observable<List<GitRepository>> =
        gitRepositoryRepo.loadSortByStarAsc()

    override fun fetchStarDesc(): Observable<List<GitRepository>> =
        gitRepositoryRepo.loadSortByStarDesc()

    override fun getSortType(): SortType = preferenceHelper.getSortType()

    override fun setSortType(type: SortType) = preferenceHelper.setSortType(type)
}