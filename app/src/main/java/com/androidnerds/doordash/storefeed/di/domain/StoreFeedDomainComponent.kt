package com.androidnerds.doordash.storefeed.di.domain

import com.androidnerds.doordash.storefeed.domain.usecase.GetStoreFeedUseCase
import dagger.Component

@Component(modules = [StoreFeedDomainModule::class])
interface StoreFeedDomainComponent {

    fun getStoreFeedUseCase(): GetStoreFeedUseCase
}

