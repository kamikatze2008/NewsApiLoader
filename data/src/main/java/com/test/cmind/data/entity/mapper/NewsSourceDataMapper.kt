package com.test.cmind.data.entity.mapper

import com.test.cmind.data.entity.NewsSourcesResponse
import com.test.cmind.data.entity.SourceResponse
import com.test.cmind.domain.entity.NewsSource

object NewsSourceDataMapper {
    fun map(newsSourcesResponse: NewsSourcesResponse): List<NewsSource> = with(newsSourcesResponse) {
        val newsSourceList = mutableListOf<NewsSource>()
        sources.forEach {
            newsSourceList.add(map(it))
        }
        newsSourceList
    }

    private fun map(sourceResponse: SourceResponse) = with(sourceResponse) {
        NewsSource(id, name, description, url)
    }
}