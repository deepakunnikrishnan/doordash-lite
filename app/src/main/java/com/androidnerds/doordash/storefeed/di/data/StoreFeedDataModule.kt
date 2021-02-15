package com.androidnerds.doordash.storefeed.di.data

import com.androidnerds.doordash.core.rx.DefaultSchedulerProvider
import com.androidnerds.doordash.core.rx.SchedulerProvider
import com.androidnerds.doordash.storefeed.data.StoreFeedRepository
import com.androidnerds.doordash.storefeed.data.local.IStoreFeedLocalDataSource
import com.androidnerds.doordash.storefeed.data.local.StoreFeedLocalDataSource
import com.androidnerds.doordash.storefeed.data.remote.IStoreFeedRemoteDataSource
import com.androidnerds.doordash.storefeed.data.remote.StoreFeedRemoteDataSource
import com.androidnerds.doordash.storefeed.domain.IStoreFeedRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [StoreFeedDataModule.BindModule::class])
class StoreFeedDataModule {

    @Module
    interface BindModule {
        @Binds
        fun bindStoreFeedRepository(repository: StoreFeedRepository) : IStoreFeedRepository
        @Binds
        fun bindSchedulerProvider(schedulerProvider: DefaultSchedulerProvider) : SchedulerProvider
    }

    @Provides
    fun provideStoreFeedRemoteDataSource(): IStoreFeedRemoteDataSource {
        return StoreFeedRemoteDataSource()
    }

    @Provides
    fun provideStoreFeedLocalDataSource(): IStoreFeedLocalDataSource {
        return StoreFeedLocalDataSource()
    }

}