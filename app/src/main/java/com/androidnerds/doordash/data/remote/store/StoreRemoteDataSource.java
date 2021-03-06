package com.androidnerds.doordash.data.remote.store;

import com.androidnerds.doordash.core.rx.SchedulerProvider;
import com.androidnerds.doordash.data.remote.model.menu.detail.MenuDetailDTO;
import com.androidnerds.doordash.data.remote.service.StoreDetailService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class StoreRemoteDataSource implements IStoreRemoteDataSource {

    private final StoreDetailService storeDetailService;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public StoreRemoteDataSource(StoreDetailService storeDetailService, SchedulerProvider schedulerProvider) {
        this.storeDetailService = storeDetailService;
        this.schedulerProvider = schedulerProvider;

    }

    @Override
    public Single<List<MenuDetailDTO>> getMenu(long storeId) {
        return storeDetailService.getMenu(storeId)
                .subscribeOn(schedulerProvider.io());
    }
}
