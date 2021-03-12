package com.androidnerds.doordash.di;

import android.content.Context;

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

public class PresentationModule {


    public static Mapper<StoreFeed, StoreFeedViewData> provideStoreFeedMapper(ListMapper<Store, StoreItemViewData> listMapper) {
        return new StoreFeedToViewMapper(listMapper);
    }

    public static ListMapper<Store, StoreItemViewData> provideStoreItemListMapper(Mapper<Store, StoreItemViewData> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    public static Mapper<Store, StoreItemViewData> provideStoreItemMapper(Context context) {
        return new StoreItemViewMapper(context);
    }


    public static Mapper<StoreDetail, StoreDetailViewData> provideStoreDetailMapper(Context context, ListMapper<Category, CategoryViewData> categoryItemViewDataListMapper) {
        return new StoreDetailToViewMapper(
                context,
                categoryItemViewDataListMapper);
    }

    public static ListMapper<Category, CategoryViewData> provideCategoryListMapper(Mapper<Category, CategoryViewData> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    public static Mapper<Category, CategoryViewData> provideCategoryMapper(ListMapper<CategoryItem, CategoryItemViewData> mapper) {
        return new CategoryToViewMapper(mapper);
    }

    public static ListMapper<CategoryItem, CategoryItemViewData> provideCategoryItemListMapper(Mapper<CategoryItem, CategoryItemViewData> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    public static Mapper<CategoryItem, CategoryItemViewData> provideCategoryItemMapper() {
        return new CategoryItemToViewMapper();
    }


}

