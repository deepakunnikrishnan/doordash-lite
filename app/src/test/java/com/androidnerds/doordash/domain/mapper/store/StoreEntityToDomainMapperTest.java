package com.androidnerds.doordash.domain.mapper.store;

import com.androidnerds.doordash.data.local.entity.StoreEntity;
import com.androidnerds.doordash.data.remote.model.StoreDTO;
import com.androidnerds.doordash.di.data.MapperModule;
import com.androidnerds.doordash.domain.model.store.Store;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class StoreEntityToDomainMapperTest {

    @Test
    public void map() {
        StoreEntity entity = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.STORE_ENTITY)
                                .getContent(),
                        StoreEntity.class);
        assertNotNull(entity);
        StoreEntityToStoreMapper entityToDomainMapper = new StoreEntityToStoreMapper(
                MapperModule.provideLocationEntitytoDomainMapper(),
                MapperModule.provideStoreStatusEntitytoDomainMapper(),
                MapperModule.provideMenuEntityListToDomainMapper(
                        MapperModule.provideMenuEntityToDomainMapper(
                                MapperModule.provideFoodItemEntityListToDomainMapper(
                                        MapperModule.provideFoodItemEntityToDomainMapper()
                                )
                        )
                ),
                MapperModule.provideMonetaryMetadataEntityToDomainMapper(),
                MapperModule.provideMerchantPromotionEntityListToDomainMapper(
                        MapperModule.provideMerchantPromotionEntityToDomainMapper(
                                MapperModule.provideMonetaryMetadataEntityToDomainMapper()
                        )
                )
        );
        Store domain = entityToDomainMapper.map(entity);
        assertNotNull(domain);
    }
}