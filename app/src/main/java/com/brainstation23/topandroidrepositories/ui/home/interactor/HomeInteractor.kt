package com.brainstation23.topandroidrepositories.ui.home.interactor

import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepositoryRepo
import com.brainstation23.topandroidrepositories.data.network.ApiHelper
import com.brainstation23.topandroidrepositories.data.network.response.model.Item
import com.brainstation23.topandroidrepositories.data.preferences.PreferenceHelper
import com.brainstation23.topandroidrepositories.ui.base.interactor.BaseInteractor
import com.brainstation23.topandroidrepositories.utils.extension.mapList
import io.reactivex.Observable
import javax.inject.Inject

class HomeInteractor @Inject constructor(
    private val gitRepositoryRepo: GitRepositoryRepo,

    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) : BaseInteractor(preferenceHelper, apiHelper), HomeMVPInteractor {

    override fun seedGitRepository(data: List<Item>?): Observable<Boolean> = when (data) {
        null -> Observable.just(false)
        else -> gitRepositoryRepo.insert(data.mapList())
    }

    override fun isCached(): Observable<Boolean> = gitRepositoryRepo.isNotEmpty()
}