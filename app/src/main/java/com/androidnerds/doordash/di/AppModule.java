package com.androidnerds.doordash.di;

import com.androidnerds.doordash.di.data.DataModule;
import com.androidnerds.doordash.di.data.MapperModule;
import com.androidnerds.doordash.di.presentation.PresentationModule;

import dagger.Module;

@Module(includes = {
        DataModule.class,
        SchedulerModule.class,
        MapperModule.class,
        PresentationModule.class

})
public class AppModule {

}
