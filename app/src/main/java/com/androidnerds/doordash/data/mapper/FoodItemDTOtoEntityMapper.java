package com.androidnerds.doordash.data.mapper;

import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.data.local.entity.FoodItemEntity;
import com.androidnerds.doordash.data.remote.model.FoodItemDTO;


public class FoodItemDTOtoEntityMapper implements Mapper<FoodItemDTO, FoodItemEntity> {

    public FoodItemDTOtoEntityMapper() {

    }

    @Override
    public FoodItemEntity map(FoodItemDTO input) {
        FoodItemEntity foodItem = new FoodItemEntity();
        foodItem.setId(input.getId());
        foodItem.setName(input.getName());
        foodItem.setDescription(input.getDescription());
        foodItem.setImageUrl(input.getImageUrl());
        foodItem.setPrice(input.getPrice());
        return foodItem;
    }
}
