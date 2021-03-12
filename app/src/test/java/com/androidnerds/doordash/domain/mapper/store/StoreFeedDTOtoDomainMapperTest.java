package com.androidnerds.doordash.domain.mapper.store;

import com.androidnerds.doordash.data.remote.model.StoreFeedDTO;
import com.androidnerds.doordash.di.MapperModule;
import com.androidnerds.doordash.domain.model.StoreFeed;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.JsonUtils;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class StoreFeedDTOtoDomainMapperTest {

    @Test
    public void map() {
        StoreFeedDTO dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.STORE_FEED_SUCCESS)
                                .getContent(),
                        StoreFeedDTO.class);
        assertNotNull(dto);
        StoreFeedDTOToStoreFeedMapper dtOtoDomainMapper = new StoreFeedDTOToStoreFeedMapper(
                MapperModule.provideStoreDTOListToStoreListMapper(
                        MapperModule.provideStoreDTOToStoreMapper(
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
                        )
                )

        );
        StoreFeed domain = dtOtoDomainMapper.map(dto);
        assertNotNull(domain);
        String content = JsonUtils.toJson(domain);
        System.out.println(content);
    }
}