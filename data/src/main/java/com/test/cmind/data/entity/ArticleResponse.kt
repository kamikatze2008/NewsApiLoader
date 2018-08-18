package com.test.cmind.data.entity

import com.google.gson.annotations.SerializedName
import java.net.URL

data class ArticleResponse(
        @SerializedName("source") val source: ArticleSourceResponse,
        @SerializedName("author") val author: String,
        @SerializedName("title") val title: String,
        @SerializedName("description") val description: String,
        @SerializedName("url") val url: URL,
        @SerializedName("urlToImage") val urlToImage: URL,
        @SerializedName("publishedAt") val publishedAt: String
)