package com.brainstation23.topandroidrepositories.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(@Expose @SerializedName("errorMsg") var message: String? = null)
