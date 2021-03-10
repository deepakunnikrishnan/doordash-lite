package com.androidnerds.doordash.data.local.store;

import com.androidnerds.doordash.data.local.dao.StoreDao;
import com.androidnerds.doordash.data.local.entity.StoreEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class StoreLocalDataSource implements IStoreLocalDataSource {

    private final StoreDao storeDao;

    @Inject
    public StoreLocalDataSource(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    @Override
    public List<Long> insertStores(List<StoreEntity> storeEntityList) {
        return storeDao.insertStores(storeEntityList);
    }

    @Override
    public Single<StoreEntity> getStore(long id) {
        return storeDao.getStore(id);
    }
}
