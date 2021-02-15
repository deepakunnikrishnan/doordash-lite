package com.androidnerds.doordash.storefeed.di.domain

import com.androidnerds.doordash.core.rx.SchedulerProvider
import com.androidnerds.doordash.storefeed.domain.IStoreFeedRepository
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class StoreFeedDomainModule(
    private val repository: Provider<IStoreFeedRepository>,
    private val schedulerProvider: SchedulerProvider
) {

    @Provides
    fun provideStoreFeedRepository(): IStoreFeedRepository = repository.get()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = schedulerProvider

}