package com.androidnerds.doordash.storefeed.data.remote;

import com.androidnerds.doordash.storefeed.data.remote.NetworkStoreFeedResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StoreFeedDao {

    @GET("/store_feed?lat={latitude}&lng={longitude}&limit={limit}&offset={offset}")
    Flowable<List<NetworkStoreFeedResponse>> getStoreFeed(@Query("latitude") double latitude,
                                                          @Query("longitude") double longitude,
                                                          @Query("limit") int limit,
                                                          @Query("offset") int offset);

    //https://api.doordash.com/v1/store_feed/?lat=37.422740&limit=50&lng=-122.139956&offset=0
}
