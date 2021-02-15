package com.androidnerds.doordash.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = application;

    @Provides
    @Singleton
    fun provideApplication(): Application = application;

}