package com.androidnerds.doordash.data.remote.feed;

import com.androidnerds.doordash.data.remote.model.StoreFeedDTO;
import com.androidnerds.doordash.data.remote.service.StoreFeedService;
import com.androidnerds.doordash.core.rx.SchedulerProvider;

import org.jetbrains.annotations.NotNull;

import io.reactivex.rxjava3.core.Single;


public class StoreFeedRemoteDataSource implements IStoreFeedRemoteDataSource {

    private StoreFeedService storeFeedService;
    private SchedulerProvider schedulerProvider;

    public StoreFeedRemoteDataSource(StoreFeedService storeFeedService, SchedulerProvider schedulerProvider) {
        this.storeFeedService = storeFeedService;
        this.schedulerProvider = schedulerProvider;
    }

    @NotNull
    @Override
    public Single<StoreFeedDTO> getStoreFeed(double latitude, double longitude, int limit, long offset) {
        return storeFeedService.getStoreFeed(
                latitude, longitude, limit, offset)
                .subscribeOn(schedulerProvider.io());
    }

}
