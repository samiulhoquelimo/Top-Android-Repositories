package com.brainstation23.topandroidrepositories.data.network.response

import com.brainstation23.topandroidrepositories.data.network.response.model.Item
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GithubRepositoryResponse(
    @Expose @SerializedName("total_count") var total_count: Int? = null,
    @Expose @SerializedName("incomplete_results") var incomplete_results: Boolean? = null,
    @Expose @SerializedName("items") var items: List<Item>? = null
)
