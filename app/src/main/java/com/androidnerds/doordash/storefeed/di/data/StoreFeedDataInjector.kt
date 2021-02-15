package com.androidnerds.doordash.storefeed.di.data

import com.androidnerds.doordash.di.CoreInjector
import com.androidnerds.doordash.storefeed.di.domain.StoreFeedDomainInjector

object StoreFeedDataInjector {

    lateinit var component: StoreFeedDataComponent

    fun initialize() {
        component = DaggerStoreFeedDataComponent.builder()
            .coreComponent(CoreInjector.coreComponent)
            .build()
        StoreFeedDomainInjector.initialize(
            component.getStoreFeedRepository(),
            component.getSchedulerProvider()
        )
    }
}
