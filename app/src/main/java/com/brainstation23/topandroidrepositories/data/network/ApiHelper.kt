package com.brainstation23.topandroidrepositories.data.network

import com.brainstation23.topandroidrepositories.data.network.request.GithubRepositoryRequest
import com.brainstation23.topandroidrepositories.data.network.response.GithubRepositoryResponse
import com.brainstation23.topandroidrepositories.data.network.response.model.Owner
import io.reactivex.Observable

interface ApiHelper {

    fun searchApiCall(request: GithubRepositoryRequest): Observable<GithubRepositoryResponse>

    fun usersApiCall(repo: String): Observable<Owner>
}