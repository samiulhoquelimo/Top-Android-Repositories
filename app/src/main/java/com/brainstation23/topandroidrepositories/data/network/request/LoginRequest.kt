package com.brainstation23.topandroidrepositories.data.network.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @Expose @SerializedName("email") internal var email: String? = null,
    @Expose @SerializedName("password") internal var password: String? = null
)
