package com.androidnerds.doordash.data.local.store;

import com.androidnerds.doordash.data.local.entity.StoreEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface IStoreLocalDataSource {

    List<Long> insertStores(List<StoreEntity> storeEntityList);

    Single<StoreEntity> getStore(long id);
}
