package com.androidnerds.doordash.presentation.restaurant.detail.viemodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.androidnerds.doordash.core.utils.Result;
import com.androidnerds.doordash.domain.usecase.GetStoreDetailUseCase;
import com.androidnerds.doordash.presentation.restaurant.detail.model.StoreDetailViewData;

public class RestaurantDetailViewModel extends ViewModel {

    private final MediatorLiveData<StoreDetailViewData> mediatorLiveData;
    private final GetStoreDetailUseCase getStoreDetailUseCase;
    private long id;

    public RestaurantDetailViewModel(long id, GetStoreDetailUseCase getStoreDetailUseCase) {
        this.id = id;
        this.getStoreDetailUseCase = getStoreDetailUseCase;
        mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.addSource(getStoreDetailUseCase.getLiveData(), this::onFetchStoreDetailResult);
        fetchStoreDetails(id);
    }

    private void fetchStoreDetails(long id) {
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