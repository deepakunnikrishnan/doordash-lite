package com.androidnerds.doordash.domain.mapper.promotion;

import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.data.local.entity.MerchantPromotionEntity;
import com.androidnerds.doordash.data.local.entity.MonetaryMetadataEntity;
import com.androidnerds.doordash.data.remote.model.MerchantPromotionDTO;
import com.androidnerds.doordash.data.remote.model.MonetaryMetadataDTO;
import com.androidnerds.doordash.domain.model.MerchantPromotion;
import com.androidnerds.doordash.domain.model.MonetaryMetadata;


public class MerchantPromotionEntitytoDomainMapper implements Mapper<MerchantPromotionEntity, MerchantPromotion> {

    private Mapper<MonetaryMetadataEntity, MonetaryMetadata> metadataMapper;

    public MerchantPromotionEntitytoDomainMapper(Mapper<MonetaryMetadataEntity, MonetaryMetadata> metadataMapper) {
        this.metadataMapper = metadataMapper;
    }

    @Override
    public MerchantPromotion map(MerchantPromotionEntity input) {
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
