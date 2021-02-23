package com.androidnerds.doordash.data.remote.store;

import com.androidnerds.doordash.data.remote.model.menu.detail.MenuDetailDTO;

import java.util.List;

import io.reactivex.rxjava3.core.Single;


public interface IStoreRemoteDataSource {

    Single<List<MenuDetailDTO>> getMenu(long storeId);
}
