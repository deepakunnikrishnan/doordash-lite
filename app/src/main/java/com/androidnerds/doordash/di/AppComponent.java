package com.androidnerds.doordash.di;

import android.content.Context;

import com.androidnerds.doordash.DoorDashApplication;
import com.androidnerds.doordash.presentation.home.HomeActivity;
import com.androidnerds.doordash.presentation.restaurant.detail.RestaurantDetailActivity;
import com.androidnerds.doordash.presentation.storefeed.StoreFeedFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class
})
public interface AppComponent {
    Context context();
    void inject(DoorDashApplication application);
    void inject(HomeActivity activity);
    void inject(RestaurantDetailActivity activity);
    void inject(StoreFeedFragment feedFragment);
}