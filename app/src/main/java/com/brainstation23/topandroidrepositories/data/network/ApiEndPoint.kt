package com.brainstation23.topandroidrepositories.data.network

import com.brainstation23.topandroidrepositories.utils.AppConstants

object ApiEndPoint {

    private const val BASE_URL = AppConstants.BASE_URL
    const val ENDPOINT_GITHUB_SEARCH = "$BASE_URL/search/repositories"
    const val ENDPOINT_USERS = "$BASE_URL/users"
}