package com.brainstation23.topandroidrepositories.data.network.request

import com.brainstation23.topandroidrepositories.utils.NetworkConstants
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GithubRepositoryRequest(
    @Expose @SerializedName("q") internal var q: String? = NetworkConstants.QUERY,
    @Expose @SerializedName("page") internal var page: String? = NetworkConstants.PAGE,
    @Expose @SerializedName("per_page") internal var per_page: String? = NetworkConstants.PER_PAGE,
    @Expose @SerializedName("sort") internal var sort: String? = NetworkConstants.SORT,
    @Expose @SerializedName("order") internal var order: String? = NetworkConstants.ORDER
)
