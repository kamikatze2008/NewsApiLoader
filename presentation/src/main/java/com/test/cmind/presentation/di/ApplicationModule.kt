package com.test.cmind.presentation.di

import android.content.Context
import com.test.cmind.presentation.MainApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {
    @Provides
    @Singleton
    fun context(app: MainApplication): Context {
        return app.applicationContext
    }
}