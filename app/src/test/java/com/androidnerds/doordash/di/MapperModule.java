package com.androidnerds.doordash.di;

import com.androidnerds.doordash.core.mapper.ListMapper;
import com.androidnerds.doordash.core.mapper.ListMapperImpl;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.data.local.entity.FoodItemEntity;
import com.androidnerds.doordash.data.local.entity.LocationEntity;
import com.androidnerds.doordash.data.local.entity.MenuEntity;
import com.androidnerds.doordash.data.local.entity.MerchantPromotionEntity;
import com.androidnerds.doordash.data.local.entity.MonetaryMetadataEntity;
import com.androidnerds.doordash.data.local.entity.StoreEntity;
import com.androidnerds.doordash.data.local.entity.StoreStatusEntity;
import com.androidnerds.doordash.data.mapper.FoodItemDTOtoEntityMapper;
import com.androidnerds.doordash.data.mapper.LocationDTOtoEntityMapper;
import com.androidnerds.doordash.data.mapper.MenuDTOtoEntityMapper;
import com.androidnerds.doordash.data.mapper.MerchantPromotionDTOtoEntityMapper;
import com.androidnerds.doordash.data.mapper.MonetaryMetadataDTOtoEntityMapper;
import com.androidnerds.doordash.data.mapper.StoreDTOToEntityMapper;
import com.androidnerds.doordash.data.mapper.StoreStatusDTOtoEntityMapper;
import com.androidnerds.doordash.data.remote.model.FoodItemDTO;
import com.androidnerds.doordash.data.remote.model.LocationDTO;
import com.androidnerds.doordash.data.remote.model.MerchantPromotionDTO;
import com.androidnerds.doordash.data.remote.model.MonetaryMetadataDTO;
import com.androidnerds.doordash.data.remote.model.StoreDTO;
import com.androidnerds.doordash.data.remote.model.StoreFeedDTO;
import com.androidnerds.doordash.data.remote.model.StoreStatusDTO;
import com.androidnerds.doordash.data.remote.model.category.CategoryDTO;
import com.androidnerds.doordash.data.remote.model.category.CategoryItemDTO;
import com.androidnerds.doordash.data.remote.model.menu.MenuDTO;
import com.androidnerds.doordash.data.remote.model.menu.detail.MenuDetailDTO;
import com.androidnerds.doordash.domain.mapper.category.CategoryDTOtoDomainMapper;
import com.androidnerds.doordash.domain.mapper.category.CategoryItemDTOtoDomainMapper;
import com.androidnerds.doordash.domain.mapper.location.LocationDTOtoDomainMapper;
import com.androidnerds.doordash.domain.mapper.location.LocationEntitytoDomainMapper;
import com.androidnerds.doordash.domain.mapper.menu.FoodItemDTOtoDomainMapper;
import com.androidnerds.doordash.domain.mapper.menu.FoodItemEntitytoDomainMapper;
import com.androidnerds.doordash.domain.mapper.menu.MenuDTOtoDomainMapper;
import com.androidnerds.doordash.domain.mapper.menu.MenuDetailDTOtoDomainMapper;
import com.androidnerds.doordash.domain.mapper.menu.MenuEntitytoDomainMapper;
import com.androidnerds.doordash.domain.mapper.monetarymetadata.MonetaryMetadataDTOtoDomainMapper;
import com.androidnerds.doordash.domain.mapper.monetarymetadata.MonetaryMetadataEntitytoDomainMapper;
import com.androidnerds.doordash.domain.mapper.promotion.MerchantPromotionDTOtoDomainMapper;
import com.androidnerds.doordash.domain.mapper.promotion.MerchantPromotionEntitytoDomainMapper;
import com.androidnerds.doordash.domain.mapper.status.StoreStatusDTOtoDomainMapper;
import com.androidnerds.doordash.domain.mapper.status.StoreStatusEntitytoDomainMapper;
import com.androidnerds.doordash.domain.mapper.store.StoreDTOToStoreMapper;
import com.androidnerds.doordash.domain.mapper.store.StoreEntityToStoreMapper;
import com.androidnerds.doordash.domain.mapper.store.StoreFeedDTOToStoreFeedMapper;
import com.androidnerds.doordash.domain.model.FoodItem;
import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.domain.model.Menu;
import com.androidnerds.doordash.domain.model.MerchantPromotion;
import com.androidnerds.doordash.domain.model.MonetaryMetadata;
import com.androidnerds.doordash.domain.model.StoreFeed;
import com.androidnerds.doordash.domain.model.StoreStatus;
import com.androidnerds.doordash.domain.model.category.Category;
import com.androidnerds.doordash.domain.model.category.CategoryItem;
import com.androidnerds.doordash.domain.model.menu.MenuDetail;
import com.androidnerds.doordash.domain.model.store.Store;

public abstract class MapperModule {

    public static Mapper<StoreFeedDTO, StoreFeed> provideStoreFeedDTOtoStoreFeedMapper(ListMapper<StoreDTO, Store> storeListMapper) {
        return new StoreFeedDTOToStoreFeedMapper(storeListMapper);
    }

    public static ListMapper<StoreDTO, Store> provideStoreDTOListToStoreListMapper(Mapper<StoreDTO, Store> storeMapper) {
        return new ListMapperImpl<>(storeMapper);
    }


    public static Mapper<StoreDTO, Store> provideStoreDTOToStoreMapper(Mapper<LocationDTO, Location> locationMapper,
                                                                       Mapper<StoreStatusDTO, StoreStatus> storeStatusMapper,
                                                                       ListMapper<MenuDTO, Menu> menuListMapper,
                                                                       Mapper<MonetaryMetadataDTO, MonetaryMetadata> monetaryMetadataMapper,
                                                                       ListMapper<MerchantPromotionDTO, MerchantPromotion> merchantPromotionListMapper) {
        return new StoreDTOToStoreMapper(locationMapper, storeStatusMapper, menuListMapper, monetaryMetadataMapper, merchantPromotionListMapper);
    }

    public static Mapper<LocationDTO, Location> provideLocationDTOtoDomainMapper() {
        return new LocationDTOtoDomainMapper();
    }

    public static Mapper<StoreStatusDTO, StoreStatus> provideStoreStatusDTOtoDomainMapper() {
        return new StoreStatusDTOtoDomainMapper();
    }

    public static ListMapper<MenuDTO, Menu> provideMenuDTOListToDomainMapper(Mapper<MenuDTO, Menu> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    public static Mapper<MenuDTO, Menu> provideMenuDTOToDomainMapper(ListMapper<FoodItemDTO, FoodItem> foodItemListMapper) {
        return new MenuDTOtoDomainMapper(foodItemListMapper);
    }


    public static ListMapper<FoodItemDTO, FoodItem> provideFoodItemDTOListToDomainMapper(Mapper<FoodItemDTO, FoodItem> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    public static Mapper<FoodItemDTO, FoodItem> provideFoodItemDTOToDomainMapper() {
        return new FoodItemDTOtoDomainMapper();
    }

    public static ListMapper<MerchantPromotionDTO, MerchantPromotion> provideMerchantPromotionDTOListToDomainMapper(Mapper<MerchantPromotionDTO, MerchantPromotion> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    public static Mapper<MerchantPromotionDTO, MerchantPromotion> provideMerchantPromotionDTOToDomainMapper(Mapper<MonetaryMetadataDTO, MonetaryMetadata> metadataMapper) {
        return new MerchantPromotionDTOtoDomainMapper(metadataMapper);
    }

    public static Mapper<MonetaryMetadataDTO, MonetaryMetadata> provideMonetaryMetadataDTOtoDomainMapper() {
        return new MonetaryMetadataDTOtoDomainMapper();
    }


    public static Mapper<StoreEntity, Store> provideStoreEntityToStoreMapper(Mapper<LocationEntity, Location> locationMapper,
                                                                             Mapper<StoreStatusEntity, StoreStatus> storeStatusMapper,
                                                                             ListMapper<MenuEntity, Menu> menuListMapper,
                                                                             Mapper<MonetaryMetadataEntity, MonetaryMetadata> monetaryMetadataMapper,
                                                                             ListMapper<MerchantPromotionEntity, MerchantPromotion> merchantPromotionListMapper) {
        return new StoreEntityToStoreMapper(locationMapper, storeStatusMapper, menuListMapper, monetaryMetadataMapper, merchantPromotionListMapper);
    }

    public static Mapper<LocationEntity, Location> provideLocationEntitytoDomainMapper() {
        return new LocationEntitytoDomainMapper();
    }

    public static Mapper<StoreStatusEntity, StoreStatus> provideStoreStatusEntitytoDomainMapper() {
        return new StoreStatusEntitytoDomainMapper();
    }

    public static ListMapper<MenuEntity, Menu> provideMenuEntityListToDomainMapper(Mapper<MenuEntity, Menu> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    public static Mapper<MenuEntity, Menu> provideMenuEntityToDomainMapper(ListMapper<FoodItemEntity, FoodItem> foodItemListMapper) {
        return new MenuEntitytoDomainMapper(foodItemListMapper);
    }


    public static ListMapper<FoodItemEntity, FoodItem> provideFoodItemEntityListToDomainMapper(Mapper<FoodItemEntity, FoodItem> mapper) {
        return new ListMapperImpl<>(mapper);
    }


    public static Mapper<FoodItemEntity, FoodItem> provideFoodItemEntityToDomainMapper() {
        return new FoodItemEntitytoDomainMapper();
    }

    public static ListMapper<MerchantPromotionEntity, MerchantPromotion> provideMerchantPromotionEntityListToDomainMapper(Mapper<MerchantPromotionEntity, MerchantPromotion> mapper) {
        return new ListMapperImpl<>(mapper);
    }


    public static Mapper<MerchantPromotionEntity, MerchantPromotion> provideMerchantPromotionEntityToDomainMapper(Mapper<MonetaryMetadataEntity, MonetaryMetadata> metadataMapper) {
        return new MerchantPromotionEntitytoDomainMapper(metadataMapper);
    }

    public static Mapper<MonetaryMetadataEntity, MonetaryMetadata> provideMonetaryMetadataEntityToDomainMapper() {
        return new MonetaryMetadataEntitytoDomainMapper();
    }

    public static Mapper<MenuDetailDTO, MenuDetail> provideMenuDetailDTOtoDomainMapper(ListMapper<CategoryDTO, Category> categoryListMapper) {
        return new MenuDetailDTOtoDomainMapper(categoryListMapper);
    }

    public static ListMapper<CategoryDTO, Category> provideCategoryDTOListToDomainMapper(Mapper<CategoryDTO, Category> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    public static Mapper<CategoryDTO, Category> provideCategoryDTOtoDomainMapper(ListMapper<CategoryItemDTO, CategoryItem> categoryItemListMapper) {
        return new CategoryDTOtoDomainMapper(categoryItemListMapper);
    }

    public static ListMapper<CategoryItemDTO, CategoryItem> provideCategoryItemDTOListToDomainMapper(Mapper<CategoryItemDTO, CategoryItem> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    public static Mapper<CategoryItemDTO, CategoryItem> provideCategoryItemDTOtoDomainMapper(Mapper<MonetaryMetadataDTO, MonetaryMetadata> monetaryMetadataMapper) {
        return new CategoryItemDTOtoDomainMapper(monetaryMetadataMapper);
    }

    public static ListMapper<StoreDTO, StoreEntity> provideStoreDTOListToStoreEntityListMapper(Mapper<StoreDTO, StoreEntity> storeMapper) {
        return new ListMapperImpl<>(storeMapper);
    }

    public static Mapper<StoreDTO, StoreEntity> provideStoreDTOToStoreEntityMapper(Mapper<LocationDTO, LocationEntity> locationMapper,
                                                                                   Mapper<StoreStatusDTO, StoreStatusEntity> storeStatusMapper,
                                                                                   ListMapper<MenuDTO, MenuEntity> menuListMapper,
                                                                                   Mapper<MonetaryMetadataDTO, MonetaryMetadataEntity> monetaryMetadataMapper,
                                                                                   ListMapper<MerchantPromotionDTO, MerchantPromotionEntity> merchantPromotionListMapper) {
        return new StoreDTOToEntityMapper(locationMapper, storeStatusMapper, menuListMapper, monetaryMetadataMapper, merchantPromotionListMapper);
    }

    public static Mapper<LocationDTO, LocationEntity> provideLocationDTOtoEntityMapper() {
        return new LocationDTOtoEntityMapper();
    }

    public static Mapper<StoreStatusDTO, StoreStatusEntity> provideStoreStatusDTOtoEntityMapper() {
        return new StoreStatusDTOtoEntityMapper();
    }

    public static ListMapper<MenuDTO, MenuEntity> provideMenuDTOListToEntityMapper(Mapper<MenuDTO, MenuEntity> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    public static Mapper<MenuDTO, MenuEntity> provideMenuDTOToEntityMapper(ListMapper<FoodItemDTO, FoodItemEntity> foodItemListMapper) {
        return new MenuDTOtoEntityMapper(foodItemListMapper);
    }

    public static ListMapper<FoodItemDTO, FoodItemEntity> provideFoodItemDTOListToEntityMapper(Mapper<FoodItemDTO, FoodItemEntity> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    public static Mapper<FoodItemDTO, FoodItemEntity> provideFoodItemDTOToEntityMapper() {
        return new FoodItemDTOtoEntityMapper();
    }

    public static ListMapper<MerchantPromotionDTO, MerchantPromotionEntity> provideMerchantPromotionDTOListToEntityMapper(Mapper<MerchantPromotionDTO, MerchantPromotionEntity> mapper) {
        return new ListMapperImpl<>(mapper);
    }


    public static Mapper<MerchantPromotionDTO, MerchantPromotionEntity> provideMerchantPromotionDTOToEntityMapper(Mapper<MonetaryMetadataDTO, MonetaryMetadataEntity> metadataMapper) {
        return new MerchantPromotionDTOtoEntityMapper(metadataMapper);
    }

    public static Mapper<MonetaryMetadataDTO, MonetaryMetadataEntity> provideMonetaryMetadataDTOtoEntityMapper() {
        return new MonetaryMetadataDTOtoEntityMapper();
    }


}

