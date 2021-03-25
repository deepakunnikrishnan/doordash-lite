package com.androidnerds.doordash.presentation.storefeed.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagingData;

import com.androidnerds.doordash.core.utils.Result;
import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.domain.usecase.GetBannerStatusUseCase;
import com.androidnerds.doordash.domain.usecase.GetStoreFeedUseCase;
import com.androidnerds.doordash.domain.usecase.GetStoresPagedDataUseCase;
import com.androidnerds.doordash.domain.usecase.SaveBannerStatusUseCase;
import com.androidnerds.doordash.presentation.storefeed.model.StoreFeedViewData;
import com.androidnerds.doordash.presentation.storefeed.model.StoreItemViewData;

import javax.inject.Inject;

/**
 * ViewModel class for the StoreList.
 * Communicates with the domain layer of the app.
 * Outputs the result via the
 * {@link #StoreFeedViewModel(GetStoreFeedUseCase,
 *  GetStoresPagedDataUseCase,
 *  GetBannerStatusUseCase,
 *  SaveBannerStatusUseCase)}
 */
public class StoreFeedViewModel extends ViewModel {

    private final double DEFAULT_LATITUDE = 37.422740;
    private final double DEFAULT_LONGITUDE = -122.139956;
    private static final int LIMIT = 50;
    private final long offset = 0;

    private final MediatorLiveData<StoreFeedViewData> mediatorLiveData;
    private final MediatorLiveData<PagingData<StoreItemViewData>> pagingDataMediatorLiveData;
    private final GetStoreFeedUseCase getStoreFeedUseCase;
    private final GetStoresPagedDataUseCase getStoresPagedDataUseCase;
    private final GetBannerStatusUseCase bannerStatusUseCase;
    private final SaveBannerStatusUseCase saveBannerStatusUseCase;

    private final MutableLiveData<Boolean> _bannerStatus = new MutableLiveData<>();
    private final LiveData<Boolean> bannerStatus = _bannerStatus;

    @Inject
    public StoreFeedViewModel(GetStoreFeedUseCase getStoreFeedUseCase,
                              GetStoresPagedDataUseCase getStoresPagedDataUseCase,
                              GetBannerStatusUseCase bannerStatusUseCase,
                              SaveBannerStatusUseCase saveBannerStatusUseCase) {
        this.getStoreFeedUseCase = getStoreFeedUseCase;
        this.getStoresPagedDataUseCase = getStoresPagedDataUseCase;
        this.bannerStatusUseCase = bannerStatusUseCase;
        this.saveBannerStatusUseCase = saveBannerStatusUseCase;
        mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.addSource(getStoreFeedUseCase.getLiveData(), this::onFetchStoreFeedResult);
        mediatorLiveData.addSource(bannerStatusUseCase.getLiveData(), result -> {
            if(result.getData() != null) {
                _bannerStatus.postValue(result.getData());
            }
        });
        pagingDataMediatorLiveData = new MediatorLiveData<>();
        pagingDataMediatorLiveData.addSource(getStoresPagedDataUseCase.getLiveData(), this::onFetchStoreResults);
        fetchBannerStatus();
        fetchStores(DEFAULT_LATITUDE, DEFAULT_LONGITUDE);
        //fetchStoreFeed(DEFAULT_LATITUDE, DEFAULT_LONGITUDE);
    }

    private void fetchStores(double latitude, double longitude) {
        getStoresPagedDataUseCase.execute(new Location(latitude, longitude), LIMIT);
    }

    private void fetchStoreFeed(double latitude, double longitude) {
        getStoreFeedUseCase.execute(new Location(latitude, longitude), LIMIT, offset);
    }

    private void fetchBannerStatus() {
        bannerStatusUseCase.execute();
    }

    public LiveData<StoreFeedViewData> getStoreFeed() {
        return mediatorLiveData;
    }

    public LiveData<PagingData<StoreItemViewData>> getStorePagingData() {
        return pagingDataMediatorLiveData;
    }

    public LiveData<Boolean> getBannerStatus() {
        return bannerStatus;
    }

    private void onFetchStoreFeedResult(Result<StoreFeedViewData, Throwable> result) {
        if (result.getData() != null) {
            mediatorLiveData.setValue(result.getData());
        }
    }

    private void onFetchStoreResults(Result<PagingData<StoreItemViewData>, Throwable> result) {
        if (result.getData() != null) {
            pagingDataMediatorLiveData.setValue(result.getData());
        }
    }

    public void saveBannerPreference(boolean closed) {
        this.saveBannerStatusUseCase.execute(closed);
    }

    @Override
    protected void onCleared() {
        getStoreFeedUseCase.cleanUp();
        super.onCleared();
    }
}