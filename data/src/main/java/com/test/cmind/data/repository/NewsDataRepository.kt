package com.test.cmind.data.repository

import com.test.cmind.data.datasource.NewsDataSource
import com.test.cmind.data.entity.mapper.ArticleDataMapper
import com.test.cmind.data.entity.mapper.NewsSourceDataMapper
import com.test.cmind.domain.entity.Article
import com.test.cmind.domain.entity.NewsSource
import com.test.cmind.domain.repository.NewsRepository
import io.reactivex.Single
import javax.inject.Inject

class NewsDataRepository @Inject constructor(private val newsDataSource: NewsDataSource)
    : NewsRepository {
    override fun getNewsSources(): Single<List<NewsSource>> = newsDataSource.getNewsSources()
            .map { NewsSourceDataMapper.map(it) }

    override fun getArticlesBySourceId(sources: String): Single<List<Article>>
            = newsDataSource.getTopHeadlines(sources).map { ArticleDataMapper.map(it) }
}