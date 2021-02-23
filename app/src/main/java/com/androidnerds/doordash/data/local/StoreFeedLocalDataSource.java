package com.androidnerds.doordash.data.local;

import com.androidnerds.doordash.data.local.dao.StoreDao;
import com.androidnerds.doordash.data.local.dao.StoreFeedDao;
import com.androidnerds.doordash.data.local.entity.StoreFeedEntity;
import com.androidnerds.doordash.core.rx.SchedulerProvider;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public class StoreFeedLocalDataSource implements IStoreFeedLocalDataSource {

    private StoreFeedDao storeFeedDao;
    private StoreDao storeDao;
    private SchedulerProvider schedulerProvider;

    public StoreFeedLocalDataSource(StoreFeedDao storeFeedDao,
                                    StoreDao storeDao,
                                    SchedulerProvider schedulerProvider) {
        this.storeFeedDao = storeFeedDao;
        this.storeDao = storeDao;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public Maybe<StoreFeedEntity> getStoreFeed(double latitude, double longitude, int limit, long offset) {
        return Maybe.just(new StoreFeedEntity());

    }

    @Override
    public Single<Integer> getStoreFeedCount() {
        return storeFeedDao.getStoreFeedCount();
    }
}
