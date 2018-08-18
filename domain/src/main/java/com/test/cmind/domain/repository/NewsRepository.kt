package com.test.cmind.domain.repository

import com.test.cmind.domain.entity.Article
import com.test.cmind.domain.entity.NewsSource
import io.reactivex.Single

interface NewsRepository {
    fun getNewsSources(): Single<List<NewsSource>>

    fun getArticlesBySourceId(sources: String): Single<List<Article>>

}