package com.test.cmind.data

import com.test.cmind.data.entity.NewsSourcesResponse
import com.test.cmind.data.entity.TopHeadlinesResponse
import io.reactivex.Single
import retrofit2.http.Field

interface NewsApi {
    fun getNewsSources(): Single<NewsSourcesResponse>

    fun getTopHeadlines(@Field("sources") sources: String): Single<TopHeadlinesResponse>
}