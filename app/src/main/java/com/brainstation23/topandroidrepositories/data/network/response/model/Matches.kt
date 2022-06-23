package com.brainstation23.topandroidrepositories.data.network.response.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Matches(
    @Expose @SerializedName("text") var text: String? = null,
    @Expose @SerializedName("indices") var indices: String? = null
)
