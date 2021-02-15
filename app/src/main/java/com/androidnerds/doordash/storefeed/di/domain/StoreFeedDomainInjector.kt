package com.androidnerds.doordash.storefeed.di.domain

import com.androidnerds.doordash.core.rx.SchedulerProvider
import com.androidnerds.doordash.storefeed.domain.IStoreFeedRepository
import javax.inject.Provider

object StoreFeedDomainInjector {

    lateinit var component: StoreFeedDomainComponent

    fun initialize(repository: Provider<IStoreFeedRepository>, schedulerProvider: SchedulerProvider) {
        component = DaggerStoreFeedDomainComponent.builder()
            .storeFeedDomainModule(StoreFeedDomainModule(repository, schedulerProvider))
            .build()
    }
}