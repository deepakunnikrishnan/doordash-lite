package com.androidnerds.doordash.data.mapper;

import com.androidnerds.doordash.core.mapper.ListMapper;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.data.local.entity.LocationEntity;
import com.androidnerds.doordash.data.local.entity.MenuEntity;
import com.androidnerds.doordash.data.local.entity.MerchantPromotionEntity;
import com.androidnerds.doordash.data.local.entity.MonetaryMetadataEntity;
import com.androidnerds.doordash.data.local.entity.StoreEntity;
import com.androidnerds.doordash.data.local.entity.StoreStatusEntity;
import com.androidnerds.doordash.data.remote.model.LocationDTO;
import com.androidnerds.doordash.data.remote.model.MerchantPromotionDTO;
import com.androidnerds.doordash.data.remote.model.MonetaryMetadataDTO;
import com.androidnerds.doordash.data.remote.model.StoreDTO;
import com.androidnerds.doordash.data.remote.model.StoreStatusDTO;
import com.androidnerds.doordash.data.remote.model.menu.MenuDTO;

import java.util.ArrayList;


public class StoreDTOToEntityMapper implements Mapper<StoreDTO, StoreEntity> {

    private Mapper<LocationDTO, LocationEntity> locationMapper;
    private Mapper<StoreStatusDTO, StoreStatusEntity> storeStatusMapper;
    private ListMapper<MenuDTO, MenuEntity> menuListMapper;
    private Mapper<MonetaryMetadataDTO, MonetaryMetadataEntity> monetaryMetadataMapper;
    private ListMapper<MerchantPromotionDTO, MerchantPromotionEntity> merchantPromotionListMapper;

    public StoreDTOToEntityMapper(Mapper<LocationDTO, LocationEntity> locationMapper,
                                  Mapper<StoreStatusDTO, StoreStatusEntity> storeStatusMapper,
                                  ListMapper<MenuDTO, MenuEntity> menuListMapper,
                                  Mapper<MonetaryMetadataDTO, MonetaryMetadataEntity> monetaryMetadataMapper,
                                  ListMapper<MerchantPromotionDTO, MerchantPromotionEntity> merchantPromotionListMapper) {
        this.locationMapper = locationMapper;
        this.storeStatusMapper = storeStatusMapper;
        this.menuListMapper = menuListMapper;
        this.monetaryMetadataMapper = monetaryMetadataMapper;
        this.merchantPromotionListMapper = merchantPromotionListMapper;
    }

    @Override
    public StoreEntity map(StoreDTO input) {
        StoreEntity store = new StoreEntity();
        store.setId(input.getId());
        store.setBusinessId(input.getBusinessId());
        store.setName(input.getName());
        store.setDescription(input.getDescription());
        store.setCoverImageUrl(input.getCoverImageUrl());
        store.setHeaderImageUrl(input.getHeaderImageUrl());

        store.setNumRatings(input.getNumRatings());
        store.setAverageRating(input.getAverageRating());

        store.setPriceRange(input.getPriceRange());
        store.setNextOpenTime(input.getNextOpenTime());
        store.setNextCloseTime(input.getNextCloseTime());

        store.setLocation(locationMapper.map(input.getLocation()));
        store.setStoreStatus(storeStatusMapper.map(input.getStoreStatus()));

        store.setUrl(input.getUrl());
        store.setMenuList((ArrayList<MenuEntity>) menuListMapper.map(input.getMenuList()));
        store.setServiceRate(input.getServiceRate());

        store.setDeliveryFee(input.getDeliveryFee());
        store.setDeliveryFeeMonetaryFields(monetaryMetadataMapper.map(input.getDeliveryFeeMonetaryFields()));

        store.setExtraSOSDeliveryFee(input.getExtraSOSDeliveryFee());
        store.setSosDeliveryFeeMonetaryFields(monetaryMetadataMapper.map(input.getSosDeliveryFeeMonetaryFields()));

        store.setNewlyAdded(input.isNewlyAdded());
        store.setConsumerSubscriptionEligible(input.isConsumerSubscriptionEligible());
        store.setDistanceFromConsumer(input.getDistanceFromConsumer());
        store.setMerchantPromotions((ArrayList<MerchantPromotionEntity>) merchantPromotionListMapper.map(input.getMerchantPromotions()));

        return store;
    }
}
