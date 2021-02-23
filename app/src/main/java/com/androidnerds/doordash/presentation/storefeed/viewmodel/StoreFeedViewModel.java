package com.androidnerds.doordash.presentation.storefeed.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.androidnerds.doordash.core.utils.Result;
import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.domain.model.StoreFeed;
import com.androidnerds.doordash.domain.usecase.GetStoreFeedUseCase;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.presentation.storefeed.model.StoreFeedViewData;
import com.androidnerds.doordash.presentation.storefeed.model.StoreItemViewData;

import java.util.List;

public class StoreFeedViewModel extends ViewModel {

    private double DEFAULT_LATITUDE = 37.422740;
    private double DEFAULT_LONGITUDE = -122.139956;
    private static final int LIMIT = 50;
    private long offset = 0;

    private final MediatorLiveData<StoreFeedViewData> mediatorLiveData;
    private final MutableLiveData<List<StoreItemViewData>> _storeListMutableLiveData = new MutableLiveData<>();
    public LiveData<List<StoreItemViewData>> storesListLiveData = _storeListMutableLiveData;

    private final GetStoreFeedUseCase getStoreFeedUseCase;

    public StoreFeedViewModel(GetStoreFeedUseCase getStoreFeedUseCase) {
        this.getStoreFeedUseCase = getStoreFeedUseCase;
        mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.addSource(getStoreFeedUseCase.getLiveData(), this::onFetchStoreFeedResult);
        fetchStoreFeed(DEFAULT_LATITUDE, DEFAULT_LONGITUDE);
    }

    private void fetchStoreFeed(double latitude, double longitude) {
        getStoreFeedUseCase.execute(new Location(latitude, longitude), LIMIT, offset);
    }

    public LiveData<StoreFeedViewData> getStoreFeed() {
        return mediatorLiveData;
    }

    private void onFetchStoreFeedResult(Result<StoreFeedViewData,Throwable> result) {
        if(result.getData() != null) {
            mediatorLiveData.setValue(result.getData());
        }
    }

    public void onStoreSelected(StoreItemViewData storeItemViewData) {

    }

    @Override
    protected void onCleared() {
        getStoreFeedUseCase.cleanUp();
        super.onCleared();
    }
}