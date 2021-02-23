package com.androidnerds.doordash.core.rx;


import io.reactivex.rxjava3.core.Scheduler;

public interface SchedulerProvider {

    Scheduler mainThread();
    Scheduler io();
    Scheduler newThread();

}

