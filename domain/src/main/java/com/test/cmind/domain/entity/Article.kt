package com.test.cmind.domain.entity

import java.net.URL
import java.util.*

data class Article(
        val author: String,
        val title: String,
        val description: String,
        val urlToImage: URL,
        val publishedAt: Date
)