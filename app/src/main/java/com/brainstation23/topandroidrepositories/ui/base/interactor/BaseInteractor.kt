package com.brainstation23.topandroidrepositories.ui.base.interactor

import com.brainstation23.topandroidrepositories.data.network.ApiHelper
import com.brainstation23.topandroidrepositories.data.network.request.GithubRepositoryRequest
import com.brainstation23.topandroidrepositories.data.network.response.GithubRepositoryResponse
import com.brainstation23.topandroidrepositories.data.preferences.PreferenceHelper
import io.reactivex.Observable

open class BaseInteractor(
    val preferenceHelper: PreferenceHelper,
    val apiHelper: ApiHelper
) : MVPInteractor {

    override fun searchApiCall(request: GithubRepositoryRequest): Observable<GithubRepositoryResponse> =
        apiHelper.searchApiCall(request)
}