package com.androidnerds.doordash.core.rx

import io.reactivex.Scheduler

interface SchedulerProvider {

    fun get(): Scheduler
    val mainThread: Scheduler

    val io: Scheduler

    val newThread: Scheduler
}