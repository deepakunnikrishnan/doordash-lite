package com.androidnerds.doordash.domain.mapper.promotion;

import com.androidnerds.doordash.data.local.entity.MerchantPromotionEntity;
import com.androidnerds.doordash.data.remote.model.MerchantPromotionDTO;
import com.androidnerds.doordash.di.data.MapperModule;
import com.androidnerds.doordash.domain.model.MerchantPromotion;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MerchantPromotionEntityToDomainMapperTest {

    @Test
    public void map() {
        MerchantPromotionEntity entity = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.MERCHANT_PROMOTION_ENTITY)
                                .getContent(),
                        MerchantPromotionEntity.class);
        assertNotNull(entity);
        MerchantPromotionEntitytoDomainMapper entityToDomainMapper = new MerchantPromotionEntitytoDomainMapper(
                MapperModule.provideMonetaryMetadataEntityToDomainMapper()
        );
        MerchantPromotion domain = entityToDomainMapper.map(entity);
        assertNotNull(domain);
    }
}