package com.brainstation23.topandroidrepositories.data.network

import com.brainstation23.topandroidrepositories.data.network.request.LoginRequest
import com.brainstation23.topandroidrepositories.data.network.response.LoginResponse
import io.reactivex.Observable

interface ApiHelper {

    fun loginApiCall(request: LoginRequest): Observable<LoginResponse>
}