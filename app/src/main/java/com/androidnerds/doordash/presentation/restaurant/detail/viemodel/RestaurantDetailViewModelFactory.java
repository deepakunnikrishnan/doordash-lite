package com.androidnerds.doordash.presentation.restaurant.detail.viemodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.androidnerds.doordash.core.rx.SchedulerProvider;
import com.androidnerds.doordash.domain.usecase.GetStoreDetailUseCase;
import com.androidnerds.doordash.domain.usecase.GetStoreFeedUseCase;

import javax.inject.Inject;

public class RestaurantDetailViewModelFactory implements ViewModelProvider.Factory {

    private final RestaurantDetailViewModel viewModel;

    public RestaurantDetailViewModelFactory(RestaurantDetailViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(RestaurantDetailViewModel.class)) {
            return (T) viewModel;
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}