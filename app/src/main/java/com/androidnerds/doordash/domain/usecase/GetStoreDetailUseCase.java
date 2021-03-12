package com.androidnerds.doordash.domain.usecase;

import com.androidnerds.doordash.core.domain.BaseUseCase;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.core.rx.SchedulerProvider;
import com.androidnerds.doordash.core.utils.Result;
import com.androidnerds.doordash.domain.IStoreRepository;
import com.androidnerds.doordash.domain.model.menu.MenuDetail;
import com.androidnerds.doordash.domain.model.store.Store;
import com.androidnerds.doordash.domain.model.store.StoreDetail;
import com.androidnerds.doordash.presentation.restaurant.detail.model.StoreDetailViewData;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.BiFunction;

public class GetStoreDetailUseCase extends BaseUseCase<Result<StoreDetailViewData, Throwable>> {

    private final IStoreRepository storeRepository;
    private final SchedulerProvider schedulerProvider;
    private final Mapper<StoreDetail, StoreDetailViewData> mapper;

    @Inject
    public GetStoreDetailUseCase(IStoreRepository storeRepository,
                                 Mapper<StoreDetail, StoreDetailViewData> mapper,
                                 SchedulerProvider schedulerProvider) {
        this.storeRepository = storeRepository;
        this.mapper = mapper;
        this.schedulerProvider = schedulerProvider;
    }

    public void execute(long id) {
        Disposable disposable = Single.zip(storeRepository.getStore(id),
                storeRepository.getMenuDetails(id),
                StoreDetail::new)
                .map(mapper::map)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.mainThread())
                .subscribe(this::onSuccess, this::onFailure);
        track(disposable);
    }

    private void onSuccess(StoreDetailViewData storeDetailViewData) {
        liveData.postValue(new Result<>(storeDetailViewData, null));
    }

    private void onFailure(Throwable throwable) {
        liveData.postValue(new Result<>(null, throwable));
    }

}
