package com.test.cmind.data

import com.test.cmind.data.entity.NewsSourcesResponse
import retrofit2.Call
import retrofit2.http.Field

interface NewsApi {
    fun getNewsSources(): Call<NewsSourcesResponse>

    fun getTopHeadlines(@Field("sources") sources: String): Call<NewsSourcesResponse>
}