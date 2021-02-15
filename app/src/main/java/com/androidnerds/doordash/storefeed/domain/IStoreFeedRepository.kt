package com.androidnerds.doordash.storefeed.domain

import io.reactivex.Flowable

interface IStoreFeedRepository {

    fun getStoreFeed(location: Location, limit: Int, offset: Int): Flowable<StoreFeed>
}