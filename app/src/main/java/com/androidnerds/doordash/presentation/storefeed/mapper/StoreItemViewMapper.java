package com.androidnerds.doordash.presentation.storefeed.mapper;

import android.content.Context;
import android.text.TextUtils;

import com.androidnerds.doordash.R;
import com.androidnerds.doordash.core.utils.MathUtils;
import com.androidnerds.doordash.domain.model.MonetaryMetadata;
import com.androidnerds.doordash.domain.model.store.Store;
import com.androidnerds.doordash.domain.model.StoreStatus;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.presentation.storefeed.model.StoreItemViewData;
import com.androidnerds.doordash.presentation.utils.AppTextUtils;

import javax.inject.Inject;

public class StoreItemViewMapper implements Mapper<Store, StoreItemViewData> {

    private final Context context;

    @Inject
    public StoreItemViewMapper(Context context) {
        this.context = context;
    }

    @Override
    public StoreItemViewData map(Store input) {
        StoreItemViewData storeItemViewData = new StoreItemViewData();
        setStoreInfo(input, storeItemViewData);
        setDeliveryFee(input, storeItemViewData);
        setTimeRange(input, storeItemViewData);
        return storeItemViewData;
    }

    private void setStoreInfo(Store input, StoreItemViewData storeItemViewData) {
        storeItemViewData.setId(input.getId());
        storeItemViewData.setName(input.getName());
        storeItemViewData.setDescription(input.getDescription());
        setPriceRange(input, storeItemViewData);
        storeItemViewData.setAverageRating(context.getResources().getString(R.string.text_average_rating, String.valueOf(MathUtils.roundAvoid(input.getAverageRating(),1))));
        storeItemViewData.setRatings(context.getResources().getString(R.string.text_total_ratings,MathUtils.formatNumber(input.getNumRatings())));
        storeItemViewData.setImageUrl(input.getHeaderImageUrl());
    }

    private void setPriceRange(Store input, StoreItemViewData storeItemViewData) {
        storeItemViewData.setPriceRange(AppTextUtils.getPriceRange(input.getPriceRange()));;
    }

    private void setDeliveryFee(Store input, StoreItemViewData storeItemViewData) {
        StringBuilder deliveryFeeBuilder = new StringBuilder();
        MonetaryMetadata metadata = input.getDeliveryFeeMonetaryFields();
        if(input.getDeliveryFee() == 0) {
            deliveryFeeBuilder.append("Free");
        }else {
            if(!TextUtils.isEmpty(metadata.getDisplayString())) {
                deliveryFeeBuilder.append(metadata.getDisplayString());
            }
        }
        storeItemViewData.setDeliveryFee(context.getResources().getString(R.string.text_delivery_fee,deliveryFeeBuilder.toString()));
    }

    private void setTimeRange(Store input, StoreItemViewData storeItemViewData) {
        StringBuilder asapRangeBuilder = new StringBuilder();
        StoreStatus storeStatus = input.getStoreStatus();
        if(null != storeStatus) {
            storeItemViewData.setTimeRange(AppTextUtils.getTimeRange(storeStatus.getAsapMinuteRange()));
        }
    }
}
