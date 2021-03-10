package com.androidnerds.doordash.domain.mapper.store;

import com.androidnerds.doordash.data.remote.model.MerchantPromotionDTO;
import com.androidnerds.doordash.data.remote.model.StoreDTO;
import com.androidnerds.doordash.di.data.MapperModule;
import com.androidnerds.doordash.domain.mapper.promotion.MerchantPromotionDTOtoDomainMapper;
import com.androidnerds.doordash.domain.mapper.store.StoreDTOToStoreMapper;
import com.androidnerds.doordash.domain.model.MerchantPromotion;
import com.androidnerds.doordash.domain.model.store.Store;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.JsonUtils;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class StoreDTOtoDomainMapperTest {

    @Test
    public void map() {
        StoreDTO dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.STORE_DTO)
                                .getContent(),
                        StoreDTO.class);
        assertNotNull(dto);
        StoreDTOToStoreMapper dtOtoDomainMapper = new StoreDTOToStoreMapper(
                MapperModule.provideLocationDTOtoDomainMapper(),
                MapperModule.provideStoreStatusDTOtoDomainMapper(),
                MapperModule.provideMenuDTOListToDomainMapper(
                        MapperModule.provideMenuDTOToDomainMapper(
                                MapperModule.provideFoodItemDTOListToDomainMapper(
                                        MapperModule.provideFoodItemDTOToDomainMapper()
                                )
                        )
                ),
                MapperModule.provideMonetaryMetadataDTOtoDomainMapper(),
                MapperModule.provideMerchantPromotionDTOListToDomainMapper(
                        MapperModule.provideMerchantPromotionDTOToDomainMapper(
                                MapperModule.provideMonetaryMetadataDTOtoDomainMapper()
                        )
                )
        );
        Store domain = dtOtoDomainMapper.map(dto);
        assertNotNull(domain);
    }
}