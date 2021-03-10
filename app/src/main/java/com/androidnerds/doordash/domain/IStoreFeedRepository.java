package com.androidnerds.doordash.domain;

import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.domain.model.StoreFeed;

import io.reactivex.rxjava3.core.Observable;


public interface IStoreFeedRepository {

    Observable<StoreFeed> getStoreFeed(Location location, int limit, long offset);



}
