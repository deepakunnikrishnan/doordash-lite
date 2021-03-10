package com.androidnerds.doordash.di;

import com.androidnerds.doordash.domain.IStoreFeedRepository;
import com.androidnerds.doordash.domain.IStoreRepository;
import com.androidnerds.doordash.domain.model.StoreFeed;
import com.androidnerds.doordash.domain.model.store.StoreDetail;
import com.androidnerds.doordash.domain.usecase.GetStoreDetailUseCase;
import com.androidnerds.doordash.domain.usecase.GetStoreFeedUseCase;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.presentation.restaurant.detail.model.StoreDetailViewData;
import com.androidnerds.doordash.presentation.storefeed.model.StoreFeedViewData;
import com.androidnerds.doordash.core.rx.SchedulerProvider;

public class UseCaseModule {

    /*public static GetStoreFeedUseCase provideGetStoreFeedUseCase(IStoreFeedRepository storeFeedRepository,
                                                                 Mapper<StoreFeed, StoreFeedViewData> mapper,
                                                                 SchedulerProvider schedulerProvider) {
        return new GetStoreFeedUseCase(storeFeedRepository,
                mapper, schedulerProvider);
    }

    public static GetStoreDetailUseCase provideGetStoreDetailUseCase(IStoreRepository storeRepository,
                                                                     Mapper<StoreDetail, StoreDetailViewData> mapper,
                                                                     SchedulerProvider schedulerProvider) {
        return new GetStoreDetailUseCase(storeRepository, mapper, schedulerProvider);
    }*/



}
