package com.brainstation23.topandroidrepositories.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApiCrashError internal constructor(
    @Expose @SerializedName("errorCode") var errorCode: Int?,
    @Expose @SerializedName("errorDetail") var errorDetail: String?,
    @Expose @SerializedName("message") var message: String?,
    @Expose @SerializedName("errorBody") var errorBody: String?,
    @Expose @SerializedName("response") var response: String?,
    @Expose @SerializedName("localizedMessage") var localizedMessage: String?
)
