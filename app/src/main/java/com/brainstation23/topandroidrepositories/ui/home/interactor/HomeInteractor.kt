package com.brainstation23.topandroidrepositories.ui.home.interactor

import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepository
import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepositoryRepo
import com.brainstation23.topandroidrepositories.data.network.ApiHelper
import com.brainstation23.topandroidrepositories.data.network.request.GithubRepositoryRequest
import com.brainstation23.topandroidrepositories.data.network.response.GithubRepositoryResponse
import com.brainstation23.topandroidrepositories.data.network.response.model.Item
import com.brainstation23.topandroidrepositories.data.network.response.model.toGitRepository
import com.brainstation23.topandroidrepositories.data.preferences.PreferenceHelper
import com.brainstation23.topandroidrepositories.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

class HomeInteractor @Inject constructor(
    private val gitRepositoryRepo: GitRepositoryRepo,

    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) : BaseInteractor(preferenceHelper, apiHelper), HomeMVPInteractor {

    override fun searchApiCall(request: GithubRepositoryRequest): Observable<GithubRepositoryResponse> =
        apiHelper.searchApiCall(request)

    override fun seedGitRepository(data: List<Item>?): Observable<Boolean> = when (data) {
        null -> Observable.just(false)
        else -> gitRepositoryRepo.insert(with(arrayListOf<GitRepository>()) {
            data.forEach { model -> this.add(model.toGitRepository()) }
            this
        })
    }

    override fun isCached(): Observable<Boolean> = gitRepositoryRepo.isNotEmpty()
}