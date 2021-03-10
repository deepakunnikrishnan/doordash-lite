package com.androidnerds.doordash.data.store;

import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.data.local.entity.StoreEntity;
import com.androidnerds.doordash.data.local.store.IStoreLocalDataSource;
import com.androidnerds.doordash.data.remote.model.menu.detail.MenuDetailDTO;
import com.androidnerds.doordash.data.remote.store.IStoreRemoteDataSource;
import com.androidnerds.doordash.domain.IStoreRepository;
import com.androidnerds.doordash.domain.model.menu.MenuDetail;
import com.androidnerds.doordash.domain.model.store.Store;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class StoreRepository implements IStoreRepository {

    private final IStoreRemoteDataSource storeRemoteDataSource;
    private final IStoreLocalDataSource storeLocalDataSource;
    private final Mapper<StoreEntity, Store> storeEntityToDomainMapper;
    private final Mapper<MenuDetailDTO, MenuDetail> menuDetailDTODomainMapper;

    @Inject
    public StoreRepository(
            IStoreRemoteDataSource storeRemoteDataSource,
            IStoreLocalDataSource storeLocalDataSource,
                           Mapper<StoreEntity, Store> storeEntityToDomainMapper,
            Mapper<MenuDetailDTO, MenuDetail> menuDetailDTODomainMapper) {
        this.storeRemoteDataSource = storeRemoteDataSource;
        this.storeLocalDataSource = storeLocalDataSource;
        this.storeEntityToDomainMapper = storeEntityToDomainMapper;
        this.menuDetailDTODomainMapper = menuDetailDTODomainMapper;
    }

    @Override
    public Single<Store> getStore(long id) {
        return storeLocalDataSource.getStore(id)
                .map(storeEntity -> storeEntityToDomainMapper.map(storeEntity));
    }

    @Override
    public Single<MenuDetail> getMenuDetails(long storeId) {
        return storeRemoteDataSource.getMenu(storeId)
                .map(menuDetailDTOS -> menuDetailDTODomainMapper.map(menuDetailDTOS.get(0)));
                /*.map(menuDetailDTOList ->
                        !menuDetailDTOList.isEmpty()?
                                menuDetailDTODomainMapper.map(menuDetailDTOList.get(0)): Observable.empty());*/
    }

}
