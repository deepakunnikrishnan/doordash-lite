package com.androidnerds.doordash.data.storefeed;

import com.androidnerds.doordash.core.mapper.ListMapper;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.core.rx.SchedulerProvider;
import com.androidnerds.doordash.data.local.IStoreFeedLocalDataSource;
import com.androidnerds.doordash.data.local.entity.StoreEntity;
import com.androidnerds.doordash.data.local.store.IStoreLocalDataSource;
import com.androidnerds.doordash.data.remote.feed.IStoreFeedRemoteDataSource;
import com.androidnerds.doordash.data.remote.model.StoreDTO;
import com.androidnerds.doordash.data.remote.model.StoreFeedDTO;
import com.androidnerds.doordash.domain.IStoreFeedRepository;
import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.domain.model.StoreFeed;

import io.reactivex.rxjava3.core.Observable;


public class StoreFeedRepository implements IStoreFeedRepository {

    private IStoreFeedRemoteDataSource storeFeedRemoteDataSource;
    private IStoreFeedLocalDataSource storeFeedLocalDataSource;
    private IStoreLocalDataSource storeLocalDataSource;
    Mapper<StoreFeedDTO, StoreFeed> storeFeedDTOToDomainMapper;
    ListMapper<StoreDTO, StoreEntity> dtoStoreEntityMapper;
    private SchedulerProvider schedulerProvider;

    public StoreFeedRepository(IStoreFeedRemoteDataSource storeFeedRemoteDataSource,
                               IStoreFeedLocalDataSource storeFeedLocalDataSource,
                               IStoreLocalDataSource storeLocalDataSource,
                               Mapper<StoreFeedDTO, StoreFeed> storeFeedDTOToDomainMapper,
                               ListMapper<StoreDTO, StoreEntity> dtoStoreEntityMapper,
                               SchedulerProvider schedulerProvider) {
        this.storeFeedRemoteDataSource = storeFeedRemoteDataSource;
        this.storeFeedLocalDataSource = storeFeedLocalDataSource;
        this.storeLocalDataSource = storeLocalDataSource;
        this.storeFeedDTOToDomainMapper = storeFeedDTOToDomainMapper;
        this.dtoStoreEntityMapper = dtoStoreEntityMapper;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public Observable<StoreFeed> getStoreFeed(Location location, int limit, long offset) {
        return this.storeFeedRemoteDataSource.getStoreFeed(location.getLatitude(), location.getLongitude(), limit, offset)
                .toObservable()
                .doOnNext(storeFeedDTO -> {
                    if(null != storeFeedDTO && null != storeFeedDTO.getStores()) {
                        storeLocalDataSource.insertStores(dtoStoreEntityMapper.map(storeFeedDTO.getStores()));
                    }
                })
                .map(storeFeedDTO -> storeFeedDTOToDomainMapper.map(storeFeedDTO));
    }
}
