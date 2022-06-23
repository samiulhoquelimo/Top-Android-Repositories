package com.brainstation23.topandroidrepositories.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApiError internal constructor(
    @Expose @SerializedName("message") var message: String?,
    @Expose @SerializedName("errors") var errors: List<Error>?,
    @Expose @SerializedName("documentation_url") var documentation_url: String?
) {
    data class Error internal constructor(
        @Expose @SerializedName("resource") var resource: String?,
        @Expose @SerializedName("field") var field: String?,
        @Expose @SerializedName("code") var code: String?
    )
}
