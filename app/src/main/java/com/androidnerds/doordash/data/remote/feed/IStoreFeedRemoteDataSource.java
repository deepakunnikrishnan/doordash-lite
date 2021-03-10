package com.androidnerds.doordash.data.remote.feed;

import com.androidnerds.doordash.data.remote.model.StoreFeedDTO;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;


public interface IStoreFeedRemoteDataSource {

    Single<StoreFeedDTO> getStoreFeed(double latitude, double longitude, int limit, long offset);
}
