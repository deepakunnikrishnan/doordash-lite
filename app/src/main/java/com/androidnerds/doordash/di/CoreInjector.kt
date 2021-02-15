package com.androidnerds.doordash.di

import android.app.Application

object CoreInjector {

    lateinit var coreComponent: CoreComponent

    fun initialize(application: Application) {
        coreComponent = DaggerCoreComponent.builder()
            .coreModule(CoreModule(application))
            .build()
    }
}