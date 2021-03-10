package com.androidnerds.doordash.di;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.androidnerds.doordash.domain.usecase.GetStoreDetailUseCase;
import com.androidnerds.doordash.presentation.ViewModelFactory;
import com.androidnerds.doordash.presentation.ViewModelKey;
import com.androidnerds.doordash.presentation.restaurant.detail.viemodel.RestaurantDetailViewModel;
import com.androidnerds.doordash.presentation.restaurant.detail.viemodel.RestaurantDetailViewModelFactory;
import com.androidnerds.doordash.presentation.storefeed.viewmodel.StoreFeedViewModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import javax.inject.Provider;

import dagger.Binds;
import dagger.MapKey;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    /*@Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @MapKey
    @interface ViewModelKey {
        Class<? extends ViewModel> value();
    }

    @Provides
    RestaurantDetailViewModelFactory viewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> providerMap) {
        return new RestaurantDetailViewModelFactory(providerMap);
    }

    @Provides
    @IntoMap
    @ViewModelKey(RestaurantDetailViewModel.class)
    RestaurantDetailViewModel restaurantDetailViewModel(long id, GetStoreDetailUseCase getStoreDetailUseCase) {
        return new RestaurantDetailViewModel(id, getStoreDetailUseCase);
    }*/

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(StoreFeedViewModel.class)
    protected abstract ViewModel storeFeedViewModel(StoreFeedViewModel storeFeedViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(RestaurantDetailViewModel.class)
    protected abstract ViewModel restaurantDetailViewModel(RestaurantDetailViewModel restaurantDetailViewModel);

}