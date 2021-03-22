package com.androidnerds.doordash.di.data;

import com.androidnerds.doordash.data.local.IStoreFeedLocalDataSource;
import com.androidnerds.doordash.data.local.StoreFeedLocalDataSource;
import com.androidnerds.doordash.data.local.store.IStoreLocalDataSource;
import com.androidnerds.doordash.data.local.store.StoreLocalDataSource;
import com.androidnerds.doordash.data.remote.feed.IStoreFeedRemoteDataSource;
import com.androidnerds.doordash.data.remote.feed.StoreFeedRemoteDataSource;
import com.androidnerds.doordash.data.remote.store.IStoreRemoteDataSource;
import com.androidnerds.doordash.data.remote.store.StoreRemoteDataSource;
import com.androidnerds.doordash.data.store.StoreRepository;
import com.androidnerds.doordash.data.storefeed.StoreFeedRepository;
import com.androidnerds.doordash.domain.IStoreFeedRepository;
import com.androidnerds.doordash.domain.IStoreRepository;

import dagger.Binds;
import dagger.Module;

@Module(includes = {
        RemoteModule.class,
        LocalModule.class
})
public abstract class DataModule {

    @Binds
    public abstract IStoreFeedRepository provideStoreFeedRepository(StoreFeedRepository storeFeedRepository);

    @Binds
    public abstract IStoreRepository provideStoreRepository(StoreRepository storeRepository);

    @Binds
    public abstract IStoreRemoteDataSource provideStoreRemoteDataSource(StoreRemoteDataSource storeRemoteDataSource);

    @Binds
    public abstract IStoreLocalDataSource provideStoreLocalDataSource(StoreLocalDataSource storeLocalDataSource);

    @Binds
    public abstract IStoreFeedRemoteDataSource provideStoreFeedRemoteDataSource(StoreFeedRemoteDataSource storeFeedRemoteDataSource);

    @Binds
    public abstract IStoreFeedLocalDataSource provideStoreFeedLocalDataSource(StoreFeedLocalDataSource storeFeedLocalDataSource);



}
