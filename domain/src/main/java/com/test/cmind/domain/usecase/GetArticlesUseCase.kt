package com.test.cmind.domain.usecase

import com.test.cmind.domain.entity.Article
import com.test.cmind.domain.repository.NewsRepository

class GetArticlesUseCase(private val newsRepository: NewsRepository,
                         private val source: String
) : SingleUseCase<List<Article>, Void>() {
    override fun buildUseCaseObservable(params: Void?)
            = newsRepository.getArticlesBySourceId(source)

}