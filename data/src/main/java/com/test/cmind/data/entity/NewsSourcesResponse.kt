package com.test.cmind.data.entity

import com.google.gson.annotations.SerializedName

data class NewsSourcesResponse(
        @SerializedName("status") val status: RequestStatus,
        @SerializedName("sources") val sources: List<SourceResponse>
)