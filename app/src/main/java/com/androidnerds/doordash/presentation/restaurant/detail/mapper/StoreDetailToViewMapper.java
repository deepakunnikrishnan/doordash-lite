package com.androidnerds.doordash.presentation.restaurant.detail.mapper;

import android.content.Context;

import com.androidnerds.doordash.R;
import com.androidnerds.doordash.core.mapper.ListMapper;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.core.utils.MathUtils;
import com.androidnerds.doordash.domain.model.MonetaryMetadata;
import com.androidnerds.doordash.domain.model.StoreStatus;
import com.androidnerds.doordash.domain.model.category.Category;
import com.androidnerds.doordash.domain.model.store.Store;
import com.androidnerds.doordash.domain.model.store.StoreDetail;
import com.androidnerds.doordash.presentation.restaurant.detail.model.CategoryViewData;
import com.androidnerds.doordash.presentation.restaurant.detail.model.StoreDetailViewData;
import com.androidnerds.doordash.presentation.utils.AppTextUtils;

import java.util.Collections;
import java.util.Comparator;

public class StoreDetailToViewMapper implements Mapper<StoreDetail, StoreDetailViewData> {

    private Context context;
    private ListMapper<Category, CategoryViewData> categoryItemViewDataListMapper;

    public StoreDetailToViewMapper(Context context, ListMapper<Category, CategoryViewData> categoryItemViewDataListMapper) {
        this.context = context;
        this.categoryItemViewDataListMapper = categoryItemViewDataListMapper;
    }

    @Override
    public StoreDetailViewData map(StoreDetail input) {
        StoreDetailViewData storeDetailViewData = new StoreDetailViewData();
        setStoreInfo(input.getStore(), storeDetailViewData);
        setDeliveryFee(input.getStore(), storeDetailViewData);
        setTimeRange(input.getStore(), storeDetailViewData);
        storeDetailViewData.setCategories(categoryItemViewDataListMapper.map(input.getMenuDetail().getCategories()));
        storeDetailViewData.getCategories().sort((o1, o2) -> Integer.compare(o1.getSortId(), o2.getSortId()));
        return storeDetailViewData;
    }


    private void setStoreInfo(Store input, StoreDetailViewData storeItemViewData) {
        storeItemViewData.setId(input.getId());
        storeItemViewData.setName(input.getName());
        storeItemViewData.setDescription(input.getDescription());
        setPriceRange(input, storeItemViewData);
        storeItemViewData.setAverageRating(context.getResources().getString(R.string.text_average_rating, String.valueOf(MathUtils.roundAvoid(input.getAverageRating(),1))));
        storeItemViewData.setRatings(context.getResources().getString(R.string.text_total_ratings,MathUtils.formatNumber(input.getNumRatings())));
        storeItemViewData.setHeaderImageUrl(input.getHeaderImageUrl());
        storeItemViewData.setProfileImageUrl(input.getCoverImageUrl());
        storeItemViewData.setDistance(context.getResources().getString(R.string.text_distance, MathUtils.formatDistance(input.getDistanceFromConsumer())));
    }

    private void setPriceRange(Store input, StoreDetailViewData storeItemViewData) {
        storeItemViewData.setPriceRange(AppTextUtils.getPriceRange(input.getPriceRange()));;
    }

    private void setDeliveryFee(Store input, StoreDetailViewData storeItemViewData) {
        MonetaryMetadata metadata = input.getDeliveryFeeMonetaryFields();
        storeItemViewData.setDeliveryFee(metadata.getDisplayString());
    }

    private void setTimeRange(Store input, StoreDetailViewData storeItemViewData) {
        StoreStatus storeStatus = input.getStoreStatus();
        if(null != storeStatus) {
            storeItemViewData.setTimeRange(AppTextUtils.getTimeRange(storeStatus.getAsapMinuteRange()));
        }
    }
}
