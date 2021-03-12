package com.androidnerds.doordash.domain.mapper.promotion;

import com.androidnerds.doordash.data.remote.model.MerchantPromotionDTO;
import com.androidnerds.doordash.data.remote.model.MonetaryMetadataDTO;
import com.androidnerds.doordash.domain.model.MerchantPromotion;
import com.androidnerds.doordash.domain.model.MonetaryMetadata;
import com.androidnerds.doordash.core.mapper.Mapper;

import javax.inject.Inject;


public class MerchantPromotionDTOtoDomainMapper implements Mapper<MerchantPromotionDTO, MerchantPromotion> {

    private final Mapper<MonetaryMetadataDTO, MonetaryMetadata> metadataMapper;

    @Inject
    public MerchantPromotionDTOtoDomainMapper(Mapper<MonetaryMetadataDTO, MonetaryMetadata> metadataMapper) {
        this.metadataMapper = metadataMapper;
    }

    @Override
    public MerchantPromotion map(MerchantPromotionDTO input) {
        MerchantPromotion merchantPromotion = new MerchantPromotion();
        merchantPromotion.setId(input.getId());
        merchantPromotion.setCategoryNewStoreCustomersOnly(input.isCategoryNewStoreCustomersOnly());
        merchantPromotion.setDeliveryFee(input.getDeliveryFee());
        merchantPromotion.setDeliveryFeeMonetaryFields(metadataMapper.map(input.getDeliveryFeeMonetaryFields()));
        merchantPromotion.setMinimumSubTotal(input.getMinimumSubTotal());
        merchantPromotion.setMinimumSubTotalMonetaryFields(metadataMapper.map(input.getMinimumSubTotalMonetaryFields()));
        return merchantPromotion;
    }
}
