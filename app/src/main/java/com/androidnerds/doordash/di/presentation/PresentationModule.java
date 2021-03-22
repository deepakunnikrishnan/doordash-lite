package com.androidnerds.doordash.di.presentation;

import com.androidnerds.doordash.core.mapper.ListMapper;
import com.androidnerds.doordash.core.mapper.ListMapperImpl;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.domain.model.StoreFeed;
import com.androidnerds.doordash.domain.model.category.Category;
import com.androidnerds.doordash.domain.model.category.CategoryItem;
import com.androidnerds.doordash.domain.model.store.Store;
import com.androidnerds.doordash.domain.model.store.StoreDetail;
import com.androidnerds.doordash.presentation.restaurant.detail.mapper.CategoryItemToViewMapper;
import com.androidnerds.doordash.presentation.restaurant.detail.mapper.CategoryToViewMapper;
import com.androidnerds.doordash.presentation.restaurant.detail.mapper.StoreDetailToViewMapper;
import com.androidnerds.doordash.presentation.restaurant.detail.model.CategoryItemViewData;
import com.androidnerds.doordash.presentation.restaurant.detail.model.CategoryViewData;
import com.androidnerds.doordash.presentation.restaurant.detail.model.StoreDetailViewData;
import com.androidnerds.doordash.presentation.storefeed.mapper.StoreFeedToViewMapper;
import com.androidnerds.doordash.presentation.storefeed.mapper.StoreItemViewMapper;
import com.androidnerds.doordash.presentation.storefeed.model.StoreFeedViewData;
import com.androidnerds.doordash.presentation.storefeed.model.StoreItemViewData;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module(includes = {ViewModelModule.class})
public abstract class PresentationModule {


    @Binds
    public abstract Mapper<StoreFeed, StoreFeedViewData> provideStoreFeedMapper(StoreFeedToViewMapper mapper);

    @Provides
    public static ListMapper<Store, StoreItemViewData> provideStoreItemListMapper(Mapper<Store, StoreItemViewData> mapper) {
        return new ListMapperImpl<>(mapper);
    }
    @Binds
    public abstract Mapper<Store, StoreItemViewData> provideStoreItemMapper(StoreItemViewMapper mapper);

    @Binds
    public abstract Mapper<StoreDetail, StoreDetailViewData> provideStoreDetailMapper(StoreDetailToViewMapper mapper);

    @Provides
    public static ListMapper<Category, CategoryViewData> provideCategoryListMapper(Mapper<Category, CategoryViewData> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    @Binds
    public abstract Mapper<Category, CategoryViewData> provideCategoryMapper(CategoryToViewMapper mapper);

    @Provides
    public static ListMapper<CategoryItem, CategoryItemViewData> provideCategoryItemListMapper(Mapper<CategoryItem, CategoryItemViewData> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    @Binds
    public abstract Mapper<CategoryItem, CategoryItemViewData> provideCategoryItemMapper(CategoryItemToViewMapper mapper);

}
