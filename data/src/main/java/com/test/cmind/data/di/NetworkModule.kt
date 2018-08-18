package com.test.cmind.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.test.cmind.data.NewsApi
import com.test.cmind.data.datasource.NewsDataSource
import com.test.cmind.data.datasource.remote.NewsRemoteDataSource
import com.test.cmind.data.repository.NewsDataRepository
import com.test.cmind.domain.repository.NewsRepository
import com.test.cmind.newsapiloader.BuildConfig
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val API_KEY = "apiKey"
        private const val NEWS_API_BASE_URL = "https://newsapi.org/v2/"
    }

    @Singleton
    @Binds
    fun newsDataSource(newsApi: NewsApi): NewsDataSource {
        return NewsRemoteDataSource(newsApi)
    }

    @Singleton
    @Binds
    fun newsSourceRepository(newsDataSource: NewsDataSource): NewsRepository {
        return NewsDataRepository(newsDataSource)
    }

    @Singleton
    @Provides
    fun newsApi(retrofit: Retrofit): NewsApi {
        return retrofit.create(NewsApi::class.java)
    }

    @Singleton
    @Provides
    fun retrofit(okHttpClient: OkHttpClient,
                 gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(NEWS_API_BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .build()
    }

    @Singleton
    @Provides
    fun gson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun gsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Singleton
    @Provides
    fun okHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, apiKeyInterceptor: Interceptor)
            : OkHttpClient {
        return OkHttpClient()
                .newBuilder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(apiKeyInterceptor)
                .build()
    }

    @Singleton
    @Provides
    fun apiKeyInterceptor(): Interceptor {
        return Interceptor {
            val original = it.request()

            val newUrl = original.url().newBuilder()
                    .addQueryParameter(API_KEY, BuildConfig.API_KEY)
                    .build()

            val request = original.newBuilder()
                    .url(newUrl)
                    .build()
            it.proceed(request)
        }
    }

    @Singleton
    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
    }

}