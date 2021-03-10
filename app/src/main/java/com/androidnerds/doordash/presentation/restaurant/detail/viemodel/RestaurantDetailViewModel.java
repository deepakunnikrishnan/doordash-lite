package com.androidnerds.doordash.presentation.restaurant.detail.viemodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.androidnerds.doordash.core.utils.Result;
import com.androidnerds.doordash.domain.usecase.GetStoreDetailUseCase;
import com.androidnerds.doordash.presentation.restaurant.detail.model.StoreDetailViewData;

import javax.inject.Inject;

/**
 * UseCase implementation for fetching the store info and the menu for the store.
 * Returns the result to the presentation layer via the liveData.
 */
public class RestaurantDetailViewModel extends ViewModel {

    private final MediatorLiveData<StoreDetailViewData> mediatorLiveData;
    private final GetStoreDetailUseCase getStoreDetailUseCase;

    @Inject
    public RestaurantDetailViewModel(GetStoreDetailUseCase getStoreDetailUseCase) {
        this.getStoreDetailUseCase = getStoreDetailUseCase;
        mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.addSource(getStoreDetailUseCase.getLiveData(), this::onFetchStoreDetailResult);
    }

    public void fetchStoreDetails(long id) {
        getStoreDetailUseCase.execute(id);
    }

    public LiveData<StoreDetailViewData> getStoreDetail() {
        return mediatorLiveData;
    }

    private void onFetchStoreDetailResult(Result<StoreDetailViewData, Throwable> result) {
        if (result.getData() != null) {
            mediatorLiveData.setValue(result.getData());
        }
    }

    @Override
    protected void onCleared() {
        getStoreDetailUseCase.cleanUp();
        super.onCleared();
    }
}