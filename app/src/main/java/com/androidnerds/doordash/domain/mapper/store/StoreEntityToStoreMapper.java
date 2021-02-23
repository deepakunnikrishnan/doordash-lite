package com.androidnerds.doordash.domain.mapper.store;

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
import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.domain.model.Menu;
import com.androidnerds.doordash.domain.model.MerchantPromotion;
import com.androidnerds.doordash.domain.model.MonetaryMetadata;
import com.androidnerds.doordash.domain.model.StoreStatus;
import com.androidnerds.doordash.domain.model.store.Store;


public class StoreEntityToStoreMapper implements Mapper<StoreEntity, Store> {

    private Mapper<LocationEntity, Location> locationMapper;
    private Mapper<StoreStatusEntity, StoreStatus> storeStatusMapper;
    private ListMapper<MenuEntity, Menu> menuListMapper;
    private Mapper<MonetaryMetadataEntity, MonetaryMetadata> monetaryMetadataMapper;
    private ListMapper<MerchantPromotionEntity, MerchantPromotion> merchantPromotionListMapper;

    public StoreEntityToStoreMapper(Mapper<LocationEntity, Location> locationMapper,
                                    Mapper<StoreStatusEntity, StoreStatus> storeStatusMapper,
                                    ListMapper<MenuEntity, Menu> menuListMapper,
                                    Mapper<MonetaryMetadataEntity, MonetaryMetadata> monetaryMetadataMapper,
                                    ListMapper<MerchantPromotionEntity, MerchantPromotion> merchantPromotionListMapper) {
        this.locationMapper = locationMapper;
        this.storeStatusMapper = storeStatusMapper;
        this.menuListMapper = menuListMapper;
        this.monetaryMetadataMapper = monetaryMetadataMapper;
        this.merchantPromotionListMapper = merchantPromotionListMapper;
    }

    @Override
    public Store map(StoreEntity input) {
        Store store = new Store();
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
        store.setMenuList(menuListMapper.map(input.getMenuList()));
        store.setServiceRate(input.getServiceRate());

        store.setDeliveryFee(input.getDeliveryFee());
        store.setDeliveryFeeMonetaryFields(monetaryMetadataMapper.map(input.getDeliveryFeeMonetaryFields()));

        store.setExtraSOSDeliveryFee(input.getExtraSOSDeliveryFee());
        store.setSosDeliveryFeeMonetaryFields(monetaryMetadataMapper.map(input.getSosDeliveryFeeMonetaryFields()));

        store.setNewlyAdded(input.isNewlyAdded());
        store.setConsumerSubscriptionEligible(input.isConsumerSubscriptionEligible());
        store.setDistanceFromConsumer(input.getDistanceFromConsumer());
        store.setMerchantPromotions(merchantPromotionListMapper.map(input.getMerchantPromotions()));
        return store;
    }
}
