package com.test.cmind.data.entity

import com.google.gson.annotations.SerializedName

data class ArticleSourceResponse(
        @SerializedName("id") val id: String,
        @SerializedName("name") val name: String
)