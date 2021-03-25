package com.androidnerds.doordash.domain.usecase;

import androidx.paging.PagingData;
import androidx.paging.rxjava3.PagingRx;

import com.androidnerds.doordash.core.domain.BaseUseCase;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.core.rx.SchedulerProvider;
import com.androidnerds.doordash.core.utils.Result;
import com.androidnerds.doordash.domain.IStoreFeedRepository;
import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.domain.model.store.Store;
import com.androidnerds.doordash.presentation.storefeed.model.StoreItemViewData;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * UseCase implementation for fetching the storeFeed from the data layer.
 * Returns the result to the presentation layer via the liveData.
 */
public class GetStoresPagedDataUseCase extends BaseUseCase<Result<PagingData<StoreItemViewData>, Throwable>> {

    private final IStoreFeedRepository storeFeedRepository;
    private final SchedulerProvider schedulerProvider;
    private final Mapper<Store, StoreItemViewData> mapper;

    @Inject
    public GetStoresPagedDataUseCase(IStoreFeedRepository storeFeedRepository,
                                     Mapper<Store, StoreItemViewData> mapper,
                                     SchedulerProvider schedulerProvider) {
        this.storeFeedRepository = storeFeedRepository;
        this.mapper = mapper;
        this.schedulerProvider = schedulerProvider;
    }

    public void execute(Location location, int limit) {
        Disposable disposable = this.storeFeedRepository.getStores(location, limit)
                .map(storePagingData -> PagingRx.map(storePagingData, store -> Single.just(mapper.map(store))))
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.mainThread())
                .subscribe(this::onSuccess, this::onFailure);
        track(disposable);

    }

    private void onSuccess(PagingData<StoreItemViewData> storeItemViewDataPagingData) {
        liveData.postValue(new Result<>(storeItemViewDataPagingData, null));
    }

    private void onFailure(Throwable throwable) {
        liveData.postValue(new Result<>(null, throwable));
    }

}
