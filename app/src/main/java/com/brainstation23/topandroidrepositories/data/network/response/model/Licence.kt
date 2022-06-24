package com.brainstation23.topandroidrepositories.data.network.response.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Licence(
    @Expose @SerializedName("key") var key: String? = null,
    @Expose @SerializedName("name") var name: String? = null,
    @Expose @SerializedName("spdx_id") var spdx_id: String? = null,
    @Expose @SerializedName("url") var url: String? = null,
    @Expose @SerializedName("node_id") var node_id: String? = null
)