package com.androidnerds.doordash.storefeed.data.remote

import com.androidnerds.doordash.storefeed.domain.StoreFeed
import io.reactivex.Flowable

interface IStoreFeedRemoteDataSource {

    fun getStoreFeed(location: Location, limit: Int, offset: Int) : Flowable<StoreFeed>
}