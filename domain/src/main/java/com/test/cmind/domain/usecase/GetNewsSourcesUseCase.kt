package com.test.cmind.domain.usecase

import com.test.cmind.domain.entity.NewsSource
import com.test.cmind.domain.repository.NewsRepository
import io.reactivex.Single

class GetNewsSourcesUseCase(private val newsRepository: NewsRepository)
    : SingleUseCase<List<NewsSource>, Void>() {
    override fun buildUseCaseObservable(params: Void?) = newsRepository.getNewsSources()
}