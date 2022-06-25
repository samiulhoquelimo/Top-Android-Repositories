package com.brainstation23.topandroidrepositories.data.network.response.model

import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepository
import com.brainstation23.topandroidrepositories.utils.extension.toOffsetDateTime
import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("full_name") var full_name: String? = null,
    @SerializedName("owner") var owner: Owner? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("updated_at") var updated_at: String? = null,
    @SerializedName("stargazers_count") var stargazers_count: Int? = null
)
