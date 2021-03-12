package com.androidnerds.doordash.data.mapper;

import com.androidnerds.doordash.data.local.entity.StoreEntity;
import com.androidnerds.doordash.data.remote.model.StoreDTO;
import com.androidnerds.doordash.di.MapperModule;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class StoreDTOtoEntityMapperTest {

    @Test
    public void map() {
        StoreDTO dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.STORE_DTO)
                                .getContent(),
                        StoreDTO.class);
        assertNotNull(dto);
        StoreDTOToEntityMapper dtOtoEntityMapper = new StoreDTOToEntityMapper(
                MapperModule.provideLocationDTOtoEntityMapper(),
                MapperModule.provideStoreStatusDTOtoEntityMapper(),
                MapperModule.provideMenuDTOListToEntityMapper(
                        MapperModule.provideMenuDTOToEntityMapper(
                                MapperModule.provideFoodItemDTOListToEntityMapper(
                                        MapperModule.provideFoodItemDTOToEntityMapper()
                                )
                        )
                ),
                MapperModule.provideMonetaryMetadataDTOtoEntityMapper(),
                MapperModule.provideMerchantPromotionDTOListToEntityMapper(
                        MapperModule.provideMerchantPromotionDTOToEntityMapper(
                                MapperModule.provideMonetaryMetadataDTOtoEntityMapper()
                        )
                ));
        StoreEntity entity = dtOtoEntityMapper.map(dto);
        assertNotNull(entity);
    }
}