package com.androidnerds.doordash.di;

import com.androidnerds.doordash.core.rx.DefaultSchedulerProvider;
import com.androidnerds.doordash.core.rx.SchedulerProvider;

public abstract class SchedulerModule {

    public static SchedulerProvider provideSchedulerProvider() {
        return new DefaultSchedulerProvider();
    }
}
