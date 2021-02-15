package com.androidnerds.doordash.di

import android.app.Application
import com.androidnerds.doordash.storefeed.di.data.StoreFeedDataInjector

object AppInjector {

    fun initialize(application: Application) {
        initializeCore(application)
        initializeStoreFeed()
    }

    private fun initializeCore(application: Application) {
        CoreInjector.initialize(application)
    }

    private fun initializeStoreFeed() {
        StoreFeedDataInjector.initialize()

    }
}