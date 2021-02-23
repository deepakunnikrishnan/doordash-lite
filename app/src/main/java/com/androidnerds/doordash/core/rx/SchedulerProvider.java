package com.androidnerds.doordash.core.rx;


import io.reactivex.rxjava3.core.Scheduler;

/**
 * Interface for providing the Schedulers required by different layers of the app.
 */
public interface SchedulerProvider {

    Scheduler mainThread();
    Scheduler io();
    Scheduler newThread();

}

