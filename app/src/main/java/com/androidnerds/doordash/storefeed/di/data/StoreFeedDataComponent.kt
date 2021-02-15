package com.androidnerds.doordash.storefeed.di.data

import com.androidnerds.doordash.di.CoreComponent
import com.androidnerds.doordash.core.rx.SchedulerProvider
import com.androidnerds.doordash.storefeed.domain.IStoreFeedRepository
import dagger.Component
import javax.inject.Provider

@StoreFeedDataScope
@Component(modules = [StoreFeedDataModule::class], dependencies = [CoreComponent::class])
interface StoreFeedDataComponent : CoreComponent {

    fun getStoreFeedRepository(): Provider<IStoreFeedRepository>

    fun getSchedulerProvider():SchedulerProvider
}