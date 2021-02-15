package com.androidnerds.doordash.core.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DefaultSchedulerProvider @Inject constructor(): SchedulerProvider {
    override fun get(): Scheduler {
        TODO("Not yet implemented")
    }

    override val mainThread: Scheduler
        get() = AndroidSchedulers.mainThread()
    override val io: Scheduler
        get() = Schedulers.io()
    override val newThread: Scheduler
        get() = Schedulers.newThread()
}