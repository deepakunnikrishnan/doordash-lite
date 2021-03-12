package com.androidnerds.doordash.data.mapper;

import com.androidnerds.doordash.data.local.entity.MerchantPromotionEntity;
import com.androidnerds.doordash.data.remote.model.MerchantPromotionDTO;
import com.androidnerds.doordash.di.MapperModule;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MerchantPromotionDTOtoEntityMapperTest {

    @Test
    public void map() {
        MerchantPromotionDTO dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.MERCHANT_PROMOTION_DTO)
                                .getContent(),
                        MerchantPromotionDTO.class);
        assertNotNull(dto);
        MerchantPromotionDTOtoEntityMapper dtOtoEntityMapper = new MerchantPromotionDTOtoEntityMapper(MapperModule.provideMonetaryMetadataDTOtoEntityMapper());
        MerchantPromotionEntity entity = dtOtoEntityMapper.map(dto);
        assertNotNull(entity);

    }
}