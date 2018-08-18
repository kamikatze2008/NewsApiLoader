package com.test.cmind.data.datasource

import com.test.cmind.data.entity.NewsSourcesResponse
import com.test.cmind.data.entity.TopHeadlinesResponse
import io.reactivex.Single
import retrofit2.http.Field

interface NewsDataSource {
    fun getNewsSources(): Single<NewsSourcesResponse>

    fun getTopHeadlines(sources: String): Single<TopHeadlinesResponse>
}