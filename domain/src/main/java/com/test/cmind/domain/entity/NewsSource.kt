package com.test.cmind.domain.entity

import java.net.URL

data class NewsSource(
        val id: String,
        val name: String,
        val description: String,
        val url: URL)