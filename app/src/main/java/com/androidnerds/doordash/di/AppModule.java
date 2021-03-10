package com.androidnerds.doordash.di;

import android.content.Context;

import com.androidnerds.doordash.di.data.DataModule;
import com.androidnerds.doordash.di.data.MapperModule;

import dagger.Module;
import dagger.Provides;

@Module(includes = {
        DataModule.class,
        SchedulerModule.class,
        MapperModule.class,
        PresentationModule.class

})
public class AppModule {

    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext() {
        return context;
    }
}
