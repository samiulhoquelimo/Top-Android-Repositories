package com.brainstation23.topandroidrepositories.data.network

import com.brainstation23.topandroidrepositories.data.network.request.LoginRequest
import com.brainstation23.topandroidrepositories.data.network.response.LoginResponse
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import javax.inject.Inject

class AppApiHelper @Inject constructor() : ApiHelper {

    override fun loginApiCall(request: LoginRequest): Observable<LoginResponse> =
        Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGIN)
            .addBodyParameter(request)
            .build()
            .getObjectObservable(LoginResponse::class.java)
}

