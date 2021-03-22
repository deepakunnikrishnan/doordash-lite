package com.androidnerds.doordash.data.storefeed;

import com.androidnerds.doordash.core.mapper.ListMapper;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.core.rx.SchedulerProvider;
import com.androidnerds.doordash.data.local.IStoreFeedLocalDataSource;
import com.androidnerds.doordash.data.local.UserPreferenceDataSource;
import com.androidnerds.doordash.data.local.entity.StoreEntity;
import com.androidnerds.doordash.data.local.store.IStoreLocalDataSource;
import com.androidnerds.doordash.data.remote.feed.IStoreFeedRemoteDataSource;
import com.androidnerds.doordash.data.remote.model.StoreDTO;
import com.androidnerds.doordash.data.remote.model.StoreFeedDTO;
import com.androidnerds.doordash.domain.IStoreFeedRepository;
import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.domain.model.StoreFeed;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;


public class StoreFeedRepository implements IStoreFeedRepository {

    private final IStoreFeedRemoteDataSource storeFeedRemoteDataSource;
    private final IStoreFeedLocalDataSource storeFeedLocalDataSource;
    private final UserPreferenceDataSource userPreferenceDataSource;
    private final IStoreLocalDataSource storeLocalDataSource;
    private final Mapper<StoreFeedDTO, StoreFeed> storeFeedDTOToDomainMapper;
    private final ListMapper<StoreDTO, StoreEntity> dtoStoreEntityMapper;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public StoreFeedRepository(IStoreFeedRemoteDataSource storeFeedRemoteDataSource,
                               IStoreFeedLocalDataSource storeFeedLocalDataSource,
                               IStoreLocalDataSource storeLocalDataSource,
                               UserPreferenceDataSource userPreferenceDataSource,
                               Mapper<StoreFeedDTO, StoreFeed> storeFeedDTOToDomainMapper,
                               ListMapper<StoreDTO, StoreEntity> dtoStoreEntityMapper,
                               SchedulerProvider schedulerProvider) {
        this.storeFeedRemoteDataSource = storeFeedRemoteDataSource;
        this.storeFeedLocalDataSource = storeFeedLocalDataSource;
        this.userPreferenceDataSource = userPreferenceDataSource;
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
                .map(storeFeedDTOToDomainMapper::map);
    }

    @Override
    public Completable saveBannerStatus(boolean status) {
        return this.userPreferenceDataSource.saveBannerStatus(status);
    }

    @Override
    public Observable<Boolean> getBannerStatus() {
        return userPreferenceDataSource.bannerStatus();
    }
}
