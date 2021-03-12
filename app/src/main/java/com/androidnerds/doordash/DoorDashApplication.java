package com.androidnerds.doordash;

import android.app.Application;

import com.androidnerds.doordash.di.AppComponent;
import com.androidnerds.doordash.di.DaggerAppComponent;


public class DoorDashApplication extends Application {


    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.factory().create(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
