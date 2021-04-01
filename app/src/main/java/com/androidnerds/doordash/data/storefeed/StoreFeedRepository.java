package com.androidnerds.doordash.data.storefeed;

import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.rxjava3.PagingRx;

import com.androidnerds.doordash.core.mapper.ListMapper;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.core.rx.SchedulerProvider;
import com.androidnerds.doordash.data.local.UserPreferenceDataSource;
import com.androidnerds.doordash.data.local.entity.StoreEntity;
import com.androidnerds.doordash.data.local.store.IStoreLocalDataSource;
import com.androidnerds.doordash.data.remote.feed.IStoreFeedRemoteDataSource;
import com.androidnerds.doordash.data.remote.feed.StoreFeedPagingDataSource;
import com.androidnerds.doordash.data.remote.model.LocationDTO;
import com.androidnerds.doordash.data.remote.model.StoreDTO;
import com.androidnerds.doordash.data.remote.model.StoreFeedDTO;
import com.androidnerds.doordash.domain.IStoreFeedRepository;
import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.domain.model.StoreFeed;
import com.androidnerds.doordash.domain.model.store.Store;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;


public class StoreFeedRepository implements IStoreFeedRepository {

    private final StoreFeedPagingDataSource storeFeedPagingDataSource;
    private final IStoreFeedRemoteDataSource storeFeedRemoteDataSource;
    private final UserPreferenceDataSource userPreferenceDataSource;
    private final IStoreLocalDataSource storeLocalDataSource;
    private final Mapper<StoreFeedDTO, StoreFeed> storeFeedDTOToDomainMapper;
    private final Mapper<StoreDTO, Store> storeDTOToDomainMapper;
    private final ListMapper<StoreDTO, StoreEntity> dtoStoreEntityMapper;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public StoreFeedRepository(IStoreFeedRemoteDataSource storeFeedRemoteDataSource,
                               StoreFeedPagingDataSource storeFeedPagingDataSource,
                               IStoreLocalDataSource storeLocalDataSource,
                               UserPreferenceDataSource userPreferenceDataSource,
                               Mapper<StoreFeedDTO, StoreFeed> storeFeedDTOToDomainMapper,
                               final Mapper<StoreDTO, Store> storeDTOToDomainMapper,
                               ListMapper<StoreDTO, StoreEntity> dtoStoreEntityMapper,
                               SchedulerProvider schedulerProvider) {
        this.storeFeedRemoteDataSource = storeFeedRemoteDataSource;
        this.storeFeedPagingDataSource = storeFeedPagingDataSource;
        this.userPreferenceDataSource = userPreferenceDataSource;
        this.storeLocalDataSource = storeLocalDataSource;
        this.storeFeedDTOToDomainMapper = storeFeedDTOToDomainMapper;
        this.storeDTOToDomainMapper = storeDTOToDomainMapper;
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

    @Override
    public Flowable<PagingData<Store>> getStores(Location location, int limit) {

        this.storeFeedPagingDataSource.setLimit(limit);
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setLatitude(location.getLatitude());
        locationDTO.setLongitude(location.getLongitude());
        this.storeFeedPagingDataSource.setLocationDTO(locationDTO);

        return PagingRx.getFlowable(new Pager<>(
                new PagingConfig(
                        limit,
                        5,
                        false,
                        limit,
                        100
                ),() -> storeFeedPagingDataSource
        )).map( storeDTOPagingData -> PagingRx.map(storeDTOPagingData, storeDTO -> Single.just(storeDTOToDomainMapper.map(storeDTO))));
    }
}
