package com.androidnerds.doordash.di.data;

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

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class MapperModule {

    @Binds
    public abstract Mapper<StoreFeedDTO, StoreFeed> provideStoreFeedDTOtoStoreFeedMapper(StoreFeedDTOToStoreFeedMapper mapper);

    @Provides
    public static ListMapper<StoreDTO, Store> provideStoreDTOListToStoreListMapper(Mapper<StoreDTO, Store> storeMapper) {
        return new ListMapperImpl<>(storeMapper);
    }

    @Binds
    public abstract Mapper<StoreDTO, Store> provideStoreDTOToStoreMapper(StoreDTOToStoreMapper mapper);

    @Binds
    public abstract Mapper<LocationDTO, Location> provideLocationDTOtoDomainMapper(LocationDTOtoDomainMapper mapper);

    @Binds
    public abstract Mapper<StoreStatusDTO, StoreStatus> provideStoreStatusDTOtoDomainMapper(StoreStatusDTOtoDomainMapper mapper);

    @Provides
    public static ListMapper<MenuDTO, Menu> provideMenuDTOListToDomainMapper(Mapper<MenuDTO, Menu> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    @Binds
    public abstract Mapper<MenuDTO, Menu> provideMenuDTOToDomainMapper(MenuDTOtoDomainMapper mapper);

    @Provides
    public static ListMapper<FoodItemDTO, FoodItem> provideFoodItemDTOListToDomainMapper(Mapper<FoodItemDTO, FoodItem> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    @Binds
    public abstract Mapper<FoodItemDTO, FoodItem> provideFoodItemDTOToDomainMapper(FoodItemDTOtoDomainMapper mapper);

    @Provides
    public static ListMapper<MerchantPromotionDTO, MerchantPromotion> provideMerchantPromotionDTOListToDomainMapper(Mapper<MerchantPromotionDTO, MerchantPromotion> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    @Binds
    public abstract Mapper<MerchantPromotionDTO, MerchantPromotion> provideMerchantPromotionDTOToDomainMapper(MerchantPromotionDTOtoDomainMapper mapper);

    @Binds
    public abstract Mapper<MonetaryMetadataDTO, MonetaryMetadata> provideMonetaryMetadataDTOtoDomainMapper(MonetaryMetadataDTOtoDomainMapper mapper);

    @Binds
    public abstract Mapper<StoreEntity, Store> provideStoreEntityToStoreMapper(StoreEntityToStoreMapper mapper);

    @Binds
    public abstract Mapper<LocationEntity, Location> provideLocationEntitytoDomainMapper(LocationEntitytoDomainMapper mapper);

    @Binds
    public abstract Mapper<StoreStatusEntity, StoreStatus> provideStoreStatusEntitytoDomainMapper(StoreStatusEntitytoDomainMapper mapper);

    @Provides
    public static ListMapper<MenuEntity, Menu> provideMenuEntityListToDomainMapper(Mapper<MenuEntity, Menu> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    @Binds
    public abstract Mapper<MenuEntity, Menu> provideMenuEntityToDomainMapper(MenuEntitytoDomainMapper mapper);

    @Provides
    public static ListMapper<FoodItemEntity, FoodItem> provideFoodItemEntityListToDomainMapper(Mapper<FoodItemEntity, FoodItem> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    @Binds
    public abstract Mapper<FoodItemEntity, FoodItem> provideFoodItemEntityToDomainMapper(FoodItemEntitytoDomainMapper mapper);

    @Provides
    public static ListMapper<MerchantPromotionEntity, MerchantPromotion> provideMerchantPromotionEntityListToDomainMapper(Mapper<MerchantPromotionEntity, MerchantPromotion> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    @Binds
    public abstract Mapper<MerchantPromotionEntity, MerchantPromotion> provideMerchantPromotionEntityToDomainMapper(MerchantPromotionEntitytoDomainMapper mapper);

    @Binds
    public abstract Mapper<MonetaryMetadataEntity, MonetaryMetadata> provideMonetaryMetadataEntityToDomainMapper(MonetaryMetadataEntitytoDomainMapper mapper);

    @Binds
    public abstract Mapper<MenuDetailDTO, MenuDetail> provideMenuDetailDTOtoDomainMapper(MenuDetailDTOtoDomainMapper mapper);

    @Provides
    public static ListMapper<CategoryDTO, Category> provideCategoryDTOListToDomainMapper(Mapper<CategoryDTO, Category> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    @Binds
    public abstract Mapper<CategoryDTO, Category> provideCategoryDTOtoDomainMapper(CategoryDTOtoDomainMapper mapper);

    @Provides
    public static ListMapper<CategoryItemDTO, CategoryItem> provideCategoryItemDTOListToDomainMapper(Mapper<CategoryItemDTO, CategoryItem> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    @Binds
    public abstract Mapper<CategoryItemDTO, CategoryItem> provideCategoryItemDTOtoDomainMapper(CategoryItemDTOtoDomainMapper mapper);

    @Provides
    public static ListMapper<StoreDTO, StoreEntity> provideStoreDTOListToStoreEntityListMapper(Mapper<StoreDTO, StoreEntity> storeMapper) {
        return new ListMapperImpl<>(storeMapper);
    }

    @Binds
    public abstract Mapper<StoreDTO, StoreEntity> provideStoreDTOToStoreEntityMapper(StoreDTOToEntityMapper mapper);

    @Binds
    public abstract Mapper<LocationDTO, LocationEntity> provideLocationDTOtoEntityMapper(LocationDTOtoEntityMapper mapper);

    @Binds
    public abstract Mapper<StoreStatusDTO, StoreStatusEntity> provideStoreStatusDTOtoEntityMapper(StoreStatusDTOtoEntityMapper mapper);

    @Provides
    public static ListMapper<MenuDTO, MenuEntity> provideMenuDTOListToEntityMapper(Mapper<MenuDTO, MenuEntity> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    @Binds
    public abstract Mapper<MenuDTO, MenuEntity> provideMenuDTOToEntityMapper(MenuDTOtoEntityMapper mapper);

    @Provides
    public static ListMapper<FoodItemDTO, FoodItemEntity> provideFoodItemDTOListToEntityMapper(Mapper<FoodItemDTO, FoodItemEntity> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    @Binds
    public abstract Mapper<FoodItemDTO, FoodItemEntity> provideFoodItemDTOToEntityMapper(FoodItemDTOtoEntityMapper mapper);

    @Provides
    public static ListMapper<MerchantPromotionDTO, MerchantPromotionEntity> provideMerchantPromotionDTOListToEntityMapper(Mapper<MerchantPromotionDTO, MerchantPromotionEntity> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    @Binds
    public abstract Mapper<MerchantPromotionDTO, MerchantPromotionEntity> provideMerchantPromotionDTOToEntityMapper(MerchantPromotionDTOtoEntityMapper mapper);

    @Binds
    public abstract Mapper<MonetaryMetadataDTO, MonetaryMetadataEntity> provideMonetaryMetadataDTOtoEntityMapper(MonetaryMetadataDTOtoEntityMapper mapper);


}
