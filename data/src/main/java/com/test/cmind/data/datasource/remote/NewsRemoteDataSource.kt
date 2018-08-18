package com.test.cmind.data.datasource.remote

import com.test.cmind.data.NewsApi
import com.test.cmind.data.datasource.NewsDataSource
import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(private val newsApi: NewsApi)
    : NewsDataSource {
    override fun getNewsSources() = newsApi.getNewsSources()
    override fun getTopHeadlines(sources: String) = newsApi.getTopHeadlines(sources)
}