package com.androidnerds.doordash.di;

import com.androidnerds.doordash.core.rx.DefaultSchedulerProvider;
import com.androidnerds.doordash.core.rx.SchedulerProvider;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class SchedulerModule {

    @Binds
    public abstract SchedulerProvider provideSchedulerProvider(DefaultSchedulerProvider defaultSchedulerProvider);
}
