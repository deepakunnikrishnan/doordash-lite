package com.androidnerds.doordash.storefeed.data.local

import com.androidnerds.doordash.storefeed.domain.Location
import com.androidnerds.doordash.storefeed.domain.StoreFeed
import io.reactivex.Flowable

class StoreFeedLocalDataSource(): IStoreFeedLocalDataSource {


    override fun getStoreFeed(location: Location, limit: Int, offset: Int): Flowable<StoreFeed> {
        TODO("Not yet implemented")
    }


}