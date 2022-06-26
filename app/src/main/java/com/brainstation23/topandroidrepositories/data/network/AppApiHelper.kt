package com.brainstation23.topandroidrepositories.data.network

import com.brainstation23.topandroidrepositories.data.network.request.GithubRepositoryRequest
import com.brainstation23.topandroidrepositories.data.network.response.GithubRepositoryResponse
import com.brainstation23.topandroidrepositories.data.network.response.model.Owner
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import javax.inject.Inject

class AppApiHelper @Inject constructor() : ApiHelper {

    override fun searchApiCall(request: GithubRepositoryRequest): Observable<GithubRepositoryResponse> =
        Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_GITHUB_SEARCH)
            .addQueryParameter(request)
            .build()
            .getObjectObservable(GithubRepositoryResponse::class.java)

    override fun usersApiCall(repo: String): Observable<Owner> =
        Rx2AndroidNetworking.get("${ApiEndPoint.ENDPOINT_GITHUB_SEARCH}/$repo")
            .build()
            .getObjectObservable(Owner::class.java)
}

