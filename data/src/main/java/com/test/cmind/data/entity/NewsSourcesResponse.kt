package com.test.cmind.data.entity

import com.google.gson.annotations.SerializedName

data class NewsSourcesResponse(
        @SerializedName("status") val status: String,
        @SerializedName("sources") val sources: List<SourceResponse>
)