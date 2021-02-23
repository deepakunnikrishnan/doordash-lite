package com.androidnerds.doordash.presentation.storefeed.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.androidnerds.doordash.domain.usecase.GetStoreFeedUseCase;
import com.androidnerds.doordash.core.rx.SchedulerProvider;

public class StoreFeedViewModelFactory implements ViewModelProvider.Factory {

    private GetStoreFeedUseCase storeFeedUseCase;
    private SchedulerProvider schedulerProvider;

    public StoreFeedViewModelFactory(GetStoreFeedUseCase storeFeedUseCase, SchedulerProvider schedulerProvider) {
        this.storeFeedUseCase = storeFeedUseCase;
        this.schedulerProvider = schedulerProvider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(StoreFeedViewModel.class)) {
            return (T) new StoreFeedViewModel(storeFeedUseCase);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}