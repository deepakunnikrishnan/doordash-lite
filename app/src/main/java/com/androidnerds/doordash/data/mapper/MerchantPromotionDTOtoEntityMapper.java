package com.androidnerds.doordash.data.mapper;

import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.data.local.entity.MerchantPromotionEntity;
import com.androidnerds.doordash.data.local.entity.MonetaryMetadataEntity;
import com.androidnerds.doordash.data.remote.model.MerchantPromotionDTO;
import com.androidnerds.doordash.data.remote.model.MonetaryMetadataDTO;


public class MerchantPromotionDTOtoEntityMapper implements Mapper<MerchantPromotionDTO, MerchantPromotionEntity> {

    private Mapper<MonetaryMetadataDTO, MonetaryMetadataEntity> metadataMapper;

    public MerchantPromotionDTOtoEntityMapper(Mapper<MonetaryMetadataDTO, MonetaryMetadataEntity> metadataMapper) {
        this.metadataMapper = metadataMapper;
    }

    @Override
    public MerchantPromotionEntity map(MerchantPromotionDTO input) {
        MerchantPromotionEntity merchantPromotion = new MerchantPromotionEntity();
        merchantPromotion.setId(input.getId());
        merchantPromotion.setCategoryNewStoreCustomersOnly(input.isCategoryNewStoreCustomersOnly());
        merchantPromotion.setDeliveryFee(input.getDeliveryFee());
        merchantPromotion.setDeliveryFeeMonetaryFields(metadataMapper.map(input.getDeliveryFeeMonetaryFields()));
        merchantPromotion.setMinimumSubTotal(input.getMinimumSubTotal());
        merchantPromotion.setMinimumSubTotalMonetaryFields(metadataMapper.map(input.getMinimumSubTotalMonetaryFields()));
        return merchantPromotion;
    }
}
