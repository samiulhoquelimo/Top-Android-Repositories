package com.brainstation23.topandroidrepositories.data.network.response.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TextMatches(
    @Expose @SerializedName("object_url") var objectUrl: String? = null,
    @Expose @SerializedName("object_type") var objectType: String? = null,
    @Expose @SerializedName("property") var property: String? = null,
    @Expose @SerializedName("fragment") var fragment: String? = null,
    @Expose @SerializedName("matches") var matches: ArrayList<Matches> = arrayListOf()
)
