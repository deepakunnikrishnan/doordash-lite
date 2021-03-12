package com.androidnerds.doordash.di;

import android.content.Context;

import com.androidnerds.doordash.presentation.home.HomeActivity;
import com.androidnerds.doordash.presentation.restaurant.detail.RestaurantDetailActivity;
import com.androidnerds.doordash.presentation.storefeed.StoreFeedFragment;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class
})
public interface AppComponent {

    @Component.Factory
    interface Factory {
        AppComponent create(@BindsInstance Context context);
    }

    void inject(HomeActivity activity);
    void inject(RestaurantDetailActivity activity);
    void inject(StoreFeedFragment feedFragment);
}