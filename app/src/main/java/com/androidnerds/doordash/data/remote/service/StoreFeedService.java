package com.androidnerds.doordash.data.remote.service;

import com.androidnerds.doordash.data.remote.model.StoreFeedDTO;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StoreFeedService {

    //https://api.doordash.com/v1/stores/30/menus/?extra=categories&extra=categories.items

    //https://api.doordash.com/v1/store_feed/?lat=37.422740&lng=-122.139956&offset=50&limit=50

    @GET("v1/store_feed")
    Single<StoreFeedDTO> getStoreFeed(@Query("lat") double latitude,
                                      @Query("lng") double longitude,
                                      @Query("limit") int limit,
                                      @Query("offset") long offset);

}
