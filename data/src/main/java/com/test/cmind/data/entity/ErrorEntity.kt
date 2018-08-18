package com.test.cmind.data.entity

import com.google.gson.annotations.SerializedName

data class ErrorEntity(
        @SerializedName("status") val status: String,
        @SerializedName("code") val code: String,
        @SerializedName("message") val message: String
)