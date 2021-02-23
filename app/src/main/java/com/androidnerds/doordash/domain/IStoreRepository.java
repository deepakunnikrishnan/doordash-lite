package com.androidnerds.doordash.domain;

import com.androidnerds.doordash.domain.model.menu.MenuDetail;
import com.androidnerds.doordash.domain.model.store.Store;

import io.reactivex.rxjava3.core.Single;

public interface IStoreRepository {

    Single<Store> getStore(long id);

    Single<MenuDetail> getMenuDetails(long storeId);

}
