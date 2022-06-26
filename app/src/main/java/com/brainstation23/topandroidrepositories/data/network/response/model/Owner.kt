package com.brainstation23.topandroidrepositories.data.network.response.model

import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("login") var login: String? = null,
    @SerializedName("avatar_url") var avatar_url: String? = null
)