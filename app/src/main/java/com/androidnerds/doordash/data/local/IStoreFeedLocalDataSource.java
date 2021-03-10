package com.androidnerds.doordash.data.local;

import com.androidnerds.doordash.data.local.entity.StoreFeedEntity;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;


public interface IStoreFeedLocalDataSource {
    Maybe<StoreFeedEntity> getStoreFeed(double latitude, double longitude, int limit, long offset);
    Single<Integer> getStoreFeedCount();
}
