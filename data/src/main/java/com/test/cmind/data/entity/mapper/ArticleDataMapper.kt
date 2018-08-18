package com.test.cmind.data.entity.mapper

import com.test.cmind.data.entity.ArticleResponse
import com.test.cmind.data.entity.TopHeadlinesResponse
import com.test.cmind.domain.entity.Article
import java.util.*

object ArticleDataMapper {
    fun map(topHeadlinesResponse: TopHeadlinesResponse): List<Article> = with(topHeadlinesResponse) {
        val articleList = mutableListOf<Article>()
        articles.forEach {
            articleList.add(map(it))
        }
        articleList
    }

    private fun map(articleResponse: ArticleResponse) = with(articleResponse) {
        Article(author, title, description, urlToImage, Date())//TODO fixme
    }
}