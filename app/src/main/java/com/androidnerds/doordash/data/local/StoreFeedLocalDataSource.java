package com.androidnerds.doordash.data.local;

import com.androidnerds.doordash.data.local.dao.StoreDao;
import com.androidnerds.doordash.data.local.dao.StoreFeedDao;
import com.androidnerds.doordash.data.local.entity.StoreFeedEntity;
import com.androidnerds.doordash.core.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public class StoreFeedLocalDataSource implements IStoreFeedLocalDataSource {

    private final StoreFeedDao storeFeedDao;
    private final StoreDao storeDao;
    private final SchedulerProvider schedulerProvider;

    @Inject
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
