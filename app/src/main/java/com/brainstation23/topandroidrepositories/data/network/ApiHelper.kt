package com.brainstation23.topandroidrepositories.data.network

import com.brainstation23.topandroidrepositories.data.network.request.GithubRepositoryRequest
import com.brainstation23.topandroidrepositories.data.network.response.GithubRepositoryResponse
import io.reactivex.Observable

interface ApiHelper {

    fun searchApiCall(request: GithubRepositoryRequest): Observable<GithubRepositoryResponse>
}