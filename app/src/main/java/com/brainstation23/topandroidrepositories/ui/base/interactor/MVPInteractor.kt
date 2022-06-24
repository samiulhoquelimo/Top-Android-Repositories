package com.brainstation23.topandroidrepositories.ui.base.interactor

import com.brainstation23.topandroidrepositories.data.network.request.GithubRepositoryRequest
import com.brainstation23.topandroidrepositories.data.network.response.GithubRepositoryResponse
import io.reactivex.Observable

interface MVPInteractor {

    fun searchApiCall(request: GithubRepositoryRequest = GithubRepositoryRequest()): Observable<GithubRepositoryResponse>
}