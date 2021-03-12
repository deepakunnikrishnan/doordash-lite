package com.androidnerds.doordash.domain.mapper.promotion;

import com.androidnerds.doordash.data.remote.model.MerchantPromotionDTO;
import com.androidnerds.doordash.di.MapperModule;
import com.androidnerds.doordash.domain.model.MerchantPromotion;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MerchantPromotionDTOtoDomainMapperTest {

    @Test
    public void map() {
        MerchantPromotionDTO dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.MERCHANT_PROMOTION_DTO)
                                .getContent(),
                        MerchantPromotionDTO.class);
        assertNotNull(dto);
        MerchantPromotionDTOtoDomainMapper dtOtoDomainMapper = new MerchantPromotionDTOtoDomainMapper(
                MapperModule.provideMonetaryMetadataDTOtoDomainMapper()
        );
        MerchantPromotion domain = dtOtoDomainMapper.map(dto);
        assertNotNull(domain);
    }
}