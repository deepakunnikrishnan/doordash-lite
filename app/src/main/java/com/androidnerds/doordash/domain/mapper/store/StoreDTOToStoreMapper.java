package com.androidnerds.doordash.domain.mapper.store;

import com.androidnerds.doordash.data.remote.model.LocationDTO;
import com.androidnerds.doordash.data.remote.model.menu.MenuDTO;
import com.androidnerds.doordash.data.remote.model.MerchantPromotionDTO;
import com.androidnerds.doordash.data.remote.model.MonetaryMetadataDTO;
import com.androidnerds.doordash.data.remote.model.StoreDTO;
import com.androidnerds.doordash.data.remote.model.StoreStatusDTO;
import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.domain.model.Menu;
import com.androidnerds.doordash.domain.model.MerchantPromotion;
import com.androidnerds.doordash.domain.model.MonetaryMetadata;
import com.androidnerds.doordash.domain.model.store.Store;
import com.androidnerds.doordash.domain.model.StoreStatus;
import com.androidnerds.doordash.core.mapper.ListMapper;
import com.androidnerds.doordash.core.mapper.Mapper;

import javax.inject.Inject;


public class StoreDTOToStoreMapper implements Mapper<StoreDTO, Store> {

    private final Mapper<LocationDTO, Location> locationMapper;
    private final Mapper<StoreStatusDTO, StoreStatus> storeStatusMapper;
    private final ListMapper<MenuDTO, Menu> menuListMapper;
    private final Mapper<MonetaryMetadataDTO, MonetaryMetadata> monetaryMetadataMapper;
    private final ListMapper<MerchantPromotionDTO, MerchantPromotion> merchantPromotionListMapper;

    @Inject
    public StoreDTOToStoreMapper(Mapper<LocationDTO, Location> locationMapper,
                                 Mapper<StoreStatusDTO, StoreStatus> storeStatusMapper,
                                 ListMapper<MenuDTO, Menu> menuListMapper,
                                 Mapper<MonetaryMetadataDTO, MonetaryMetadata> monetaryMetadataMapper,
                                 ListMapper<MerchantPromotionDTO, MerchantPromotion> merchantPromotionListMapper) {
        this.locationMapper = locationMapper;
        this.storeStatusMapper = storeStatusMapper;
        this.menuListMapper = menuListMapper;
        this.monetaryMetadataMapper = monetaryMetadataMapper;
        this.merchantPromotionListMapper = merchantPromotionListMapper;
    }

    @Override
    public Store map(StoreDTO input) {
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
