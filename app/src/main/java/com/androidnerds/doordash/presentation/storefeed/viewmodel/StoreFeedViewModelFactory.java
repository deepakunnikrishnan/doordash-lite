package com.androidnerds.doordash.presentation.storefeed.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.androidnerds.doordash.domain.usecase.GetStoreFeedUseCase;
import com.androidnerds.doordash.core.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

public class StoreFeedViewModelFactory implements ViewModelProvider.Factory {

    private final StoreFeedViewModel storeFeedViewModel;

    public StoreFeedViewModelFactory(StoreFeedViewModel storeFeedViewModel) {
        this.storeFeedViewModel = storeFeedViewModel;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(StoreFeedViewModel.class)) {
            return (T) storeFeedViewModel;
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}