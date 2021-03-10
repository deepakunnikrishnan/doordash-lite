package com.androidnerds.doordash.domain.mapper.menu;

import com.androidnerds.doordash.data.remote.model.FoodItemDTO;
import com.androidnerds.doordash.domain.model.FoodItem;
import com.androidnerds.doordash.core.mapper.Mapper;


public class FoodItemDTOtoDomainMapper implements Mapper<FoodItemDTO, FoodItem> {

    public FoodItemDTOtoDomainMapper() {
    }

    @Override
    public FoodItem map(FoodItemDTO input) {
        FoodItem foodItem = new FoodItem();
        foodItem.setId(input.getId());
        foodItem.setName(input.getName());
        foodItem.setDescription(input.getDescription());
        foodItem.setImageUrl(input.getImageUrl());
        foodItem.setPrice(input.getPrice());
        return foodItem;
    }
}
