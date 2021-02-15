package com.androidnerds.doordash.storefeed.data

import com.androidnerds.doordash.core.rx.SchedulerProvider
import com.androidnerds.doordash.storefeed.data.local.IStoreFeedLocalDataSource
import com.androidnerds.doordash.storefeed.data.remote.IStoreFeedRemoteDataSource
import com.androidnerds.doordash.storefeed.domain.IStoreFeedRepository
import com.androidnerds.doordash.storefeed.domain.Location
import com.androidnerds.doordash.storefeed.domain.StoreFeed
import io.reactivex.Flowable
import javax.inject.Inject

class StoreFeedRepository @Inject constructor(
    private val localDataSource: IStoreFeedLocalDataSource,
    private val remoteDataSource: IStoreFeedRemoteDataSource,
    private val schedulerProvider: SchedulerProvider
    /*private val storeFeedDao: StoreFeedDao,
    private val storeFeedDataMapper: Mapper<NetworkStoreFeedResponse, StoreFeed>*/
) : IStoreFeedRepository {

    override fun getStoreFeed(
        location: Location,
        limit: Int,
        offset: Int
    ): Flowable<StoreFeed> {
        return remoteDataSource.getStoreFeed(
            location = com.androidnerds.doordash.storefeed.data.remote.Location(10.0,11.0),
        limit = limit,
        offset = offset)
            .subscribeOn(schedulerProvider.io)
    }

}