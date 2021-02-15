package com.androidnerds.doordash

import android.app.Application
import com.androidnerds.doordash.di.AppInjector

open class DoorDashApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    fun initializeDagger() {
        AppInjector.initialize(this)
    }
}