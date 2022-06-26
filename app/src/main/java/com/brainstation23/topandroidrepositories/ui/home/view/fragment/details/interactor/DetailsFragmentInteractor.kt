package com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.interactor

import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepository
import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepositoryRepo
import com.brainstation23.topandroidrepositories.data.network.ApiHelper
import com.brainstation23.topandroidrepositories.data.network.response.model.Owner
import com.brainstation23.topandroidrepositories.data.preferences.PreferenceHelper
import com.brainstation23.topandroidrepositories.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

class DetailsFragmentInteractor @Inject constructor(
    private val gitRepositoryRepo: GitRepositoryRepo,

    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) : BaseInteractor(preferenceHelper, apiHelper), DetailsFragmentMVPInteractor {

    override fun fetchGitRepository(id: Int): Observable<GitRepository> =
        gitRepositoryRepo.loadById(id)

    override fun usersApiCall(login: String): Observable<Owner> = apiHelper.usersApiCall(login)
}