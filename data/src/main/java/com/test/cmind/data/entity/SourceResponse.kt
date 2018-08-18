package com.test.cmind.data.entity

import com.google.gson.annotations.SerializedName
import java.net.URL

data class SourceResponse(
        @SerializedName("id") val id: String,
        @SerializedName("name") val name: String,
        @SerializedName("description") val description: String,
        @SerializedName("url") val url: URL,
        @SerializedName("category") val category: String,
        @SerializedName("language") val language: String,
        @SerializedName("country") val country: String
)