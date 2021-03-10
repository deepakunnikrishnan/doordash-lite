package com.androidnerds.doordash.di.data;

import com.androidnerds.doordash.core.mapper.ListMapper;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.core.rx.SchedulerProvider;
import com.androidnerds.doordash.data.local.IStoreFeedLocalDataSource;
import com.androidnerds.doordash.data.local.StoreFeedLocalDataSource;
import com.androidnerds.doordash.data.local.dao.StoreDao;
import com.androidnerds.doordash.data.local.dao.StoreFeedDao;
import com.androidnerds.doordash.data.local.entity.StoreEntity;
import com.androidnerds.doordash.data.local.store.IStoreLocalDataSource;
import com.androidnerds.doordash.data.local.store.StoreLocalDataSource;
import com.androidnerds.doordash.data.remote.feed.IStoreFeedRemoteDataSource;
import com.androidnerds.doordash.data.remote.feed.StoreFeedRemoteDataSource;
import com.androidnerds.doordash.data.remote.model.StoreDTO;
import com.androidnerds.doordash.data.remote.model.StoreFeedDTO;
import com.androidnerds.doordash.data.remote.model.menu.detail.MenuDetailDTO;
import com.androidnerds.doordash.data.remote.service.StoreDetailService;
import com.androidnerds.doordash.data.remote.service.StoreFeedService;
import com.androidnerds.doordash.data.remote.store.IStoreRemoteDataSource;
import com.androidnerds.doordash.data.remote.store.StoreRemoteDataSource;
import com.androidnerds.doordash.data.store.StoreRepository;
import com.androidnerds.doordash.data.storefeed.StoreFeedRepository;
import com.androidnerds.doordash.domain.IStoreFeedRepository;
import com.androidnerds.doordash.domain.IStoreRepository;
import com.androidnerds.doordash.domain.model.StoreFeed;
import com.androidnerds.doordash.domain.model.menu.MenuDetail;
import com.androidnerds.doordash.domain.model.store.Store;

import dagger.Binds;
import dagger.Module;

@Module(includes = {
        RemoteModule.class,
        LocalModule.class
})
public abstract class DataModule {

    @Binds
    public abstract IStoreFeedRepository provideStoreFeedRepository(StoreFeedRepository storeFeedRepository);

    /*public static IStoreFeedRepository provideStoreFeedRepository(IStoreFeedRemoteDataSource storeFeedRemoteDataSource,
                                                                  IStoreFeedLocalDataSource storeFeedLocalDataSource,
                                                                  IStoreLocalDataSource storeLocalDataSource,
                                                                  Mapper<StoreFeedDTO, StoreFeed> storeFeedDTOToDomainMapper,
                                                                  ListMapper<StoreDTO, StoreEntity> dtoStoreEntityMapper,
                                                                  SchedulerProvider schedulerProvider) {
        return new StoreFeedRepository(
                storeFeedRemoteDataSource,
                storeFeedLocalDataSource,
                storeLocalDataSource,
                storeFeedDTOToDomainMapper,
                dtoStoreEntityMapper,
                schedulerProvider);
    }*/

    @Binds
    public abstract IStoreRepository provideStoreRepository(StoreRepository storeRepository);
    /*public static IStoreRepository provideStoreRepository(IStoreRemoteDataSource storeRemoteDataSource,
                                                          IStoreLocalDataSource storeLocalDataSource,
                                                          Mapper<StoreEntity, Store> storeEntityToDomainMapper,
                                                          Mapper<MenuDetailDTO, MenuDetail> menuDetailDTODomainMapper) {
        return new StoreRepository(
                storeRemoteDataSource,
                storeLocalDataSource,
                storeEntityToDomainMapper,
                menuDetailDTODomainMapper
        );
    }*/

    @Binds
    public abstract IStoreRemoteDataSource provideStoreRemoteDataSource(StoreRemoteDataSource storeRemoteDataSource);

    /*public static IStoreRemoteDataSource provideStoreRemoteDataSource(StoreDetailService storeDetailService,
                                                                      SchedulerProvider schedulerProvider) {
        return new StoreRemoteDataSource(
                storeDetailService,
                schedulerProvider
        );
    }*/

    @Binds
    public abstract IStoreLocalDataSource provideStoreLocalDataSource(StoreLocalDataSource storeLocalDataSource);

    /*public static IStoreLocalDataSource provideStoreLocalDataSource(StoreDao storeDao) {
        return new StoreLocalDataSource(
                storeDao
        );
    }*/
    @Binds
    public abstract IStoreFeedRemoteDataSource provideStoreFeedRemoteDataSource(StoreFeedRemoteDataSource storeFeedRemoteDataSource);

    /*public static IStoreFeedRemoteDataSource provideStoreFeedRemoteDataSource(StoreFeedService storeFeedService,
                                                                              SchedulerProvider schedulerProvider) {
        return new StoreFeedRemoteDataSource(storeFeedService, schedulerProvider);
    }*/

    @Binds
    public abstract IStoreFeedLocalDataSource provideStoreFeedLocalDataSource(StoreFeedLocalDataSource storeFeedLocalDataSource);

    /*public static IStoreFeedLocalDataSource provideStoreFeedLocalDataSource(StoreFeedDao storeFeedDao,
                                                                            StoreDao storeDao,
                                                                            SchedulerProvider schedulerProvider) {
        return new StoreFeedLocalDataSource(storeFeedDao, storeDao, schedulerProvider);
    }*/



}
