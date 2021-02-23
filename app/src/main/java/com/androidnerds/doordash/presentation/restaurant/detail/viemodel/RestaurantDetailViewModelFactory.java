package com.androidnerds.doordash.presentation.restaurant.detail.viemodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.androidnerds.doordash.core.rx.SchedulerProvider;
import com.androidnerds.doordash.domain.usecase.GetStoreDetailUseCase;
import com.androidnerds.doordash.domain.usecase.GetStoreFeedUseCase;

public class RestaurantDetailViewModelFactory implements ViewModelProvider.Factory {

    private long id;
    private final GetStoreDetailUseCase getStoreDetailUseCase;
    private SchedulerProvider schedulerProvider;

    public RestaurantDetailViewModelFactory(long id, GetStoreDetailUseCase getStoreDetailUseCase, SchedulerProvider schedulerProvider) {
        this.id = id;
        this.getStoreDetailUseCase = getStoreDetailUseCase;
        this.schedulerProvider = schedulerProvider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(RestaurantDetailViewModel.class)) {
            return (T) new RestaurantDetailViewModel(id, getStoreDetailUseCase);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}