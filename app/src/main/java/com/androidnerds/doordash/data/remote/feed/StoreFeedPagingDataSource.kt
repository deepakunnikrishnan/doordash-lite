package com.androidnerds.doordash.data.remote.feed

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.androidnerds.doordash.core.mapper.ListMapper
import com.androidnerds.doordash.core.rx.SchedulerProvider
import com.androidnerds.doordash.data.local.entity.StoreEntity
import com.androidnerds.doordash.data.local.store.StoreLocalDataSource
import com.androidnerds.doordash.data.remote.model.LocationDTO
import com.androidnerds.doordash.data.remote.model.StoreDTO
import com.androidnerds.doordash.data.remote.model.StoreFeedDTO
import com.androidnerds.doordash.data.remote.service.StoreFeedService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class StoreFeedPagingDataSource @Inject constructor(
    private val storeFeedService: StoreFeedService,
    private val storeLocalDataSource: StoreLocalDataSource,
    private val dtoStoreEntityMapper: ListMapper<StoreDTO, StoreEntity>,
    val schedulerProvider: SchedulerProvider
): RxPagingSource<Long, StoreDTO>() {

    var locationDTO: LocationDTO? = null
    var limit: Int = 0

    override fun getRefreshKey(state: PagingState<Long, StoreDTO>): Long? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?:anchorPage?.nextKey?.minus(1)
        }

    }

    override fun loadSingle(params: LoadParams<Long>): Single<LoadResult<Long, StoreDTO>> {
        val offset = params.key ?: 0
        return storeFeedService
            .getStoreFeed(locationDTO!!.latitude, locationDTO!!.longitude, limit, offset)
            .subscribeOn(schedulerProvider.io())
            .doOnSuccess { storeLocalDataSource.insertStores(dtoStoreEntityMapper.map(it.stores)) }
            .map { storeFeed -> toLoadResult(storeFeed, limit, offset) }
    }

    private fun toLoadResult(storeFeed: StoreFeedDTO, limit: Int, position: Long): LoadResult<Long, StoreDTO> {
        return LoadResult.Page(
            data = storeFeed.stores,
            prevKey = null,
            nextKey = if(storeFeed.nextOffset == 0L) null else storeFeed.nextOffset)
    }

}