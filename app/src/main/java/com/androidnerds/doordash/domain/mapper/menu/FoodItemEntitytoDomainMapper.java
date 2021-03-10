package com.androidnerds.doordash.domain.mapper.menu;

import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.data.local.entity.FoodItemEntity;
import com.androidnerds.doordash.data.remote.model.FoodItemDTO;
import com.androidnerds.doordash.domain.model.FoodItem;


public class FoodItemEntitytoDomainMapper implements Mapper<FoodItemEntity, FoodItem> {

    public FoodItemEntitytoDomainMapper() {
    }

    @Override
    public FoodItem map(FoodItemEntity input) {
        FoodItem foodItem = new FoodItem();
        foodItem.setId(input.getId());
        foodItem.setName(input.getName());
        foodItem.setDescription(input.getDescription());
        foodItem.setImageUrl(input.getImageUrl());
        foodItem.setPrice(input.getPrice());
        return foodItem;
    }
}
