package com.androidnerds.doordash.domain;

import androidx.paging.PagingData;

import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.domain.model.StoreFeed;
import com.androidnerds.doordash.domain.model.store.Store;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;


public interface IStoreFeedRepository {

    Observable<StoreFeed> getStoreFeed(Location location, int limit, long offset);
    Completable saveBannerStatus(boolean status);
    Observable<Boolean> getBannerStatus();

    Flowable<PagingData<Store>> getStores(Location location, int limit);

}
