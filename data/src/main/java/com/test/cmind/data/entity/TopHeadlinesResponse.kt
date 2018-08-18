package com.test.cmind.data.entity

import com.google.gson.annotations.SerializedName

data class TopHeadlinesResponse(
        @SerializedName("status") val status: RequestStatus,
        @SerializedName("totalResults") val totalResults: Int,
        @SerializedName("articles") val articles: List<ArticleResponse>
)