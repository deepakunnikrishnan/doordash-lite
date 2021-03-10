package com.androidnerds.doordash.presentation.restaurant.detail.mapper;

import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.domain.model.category.CategoryItem;
import com.androidnerds.doordash.domain.model.store.StoreDetail;
import com.androidnerds.doordash.presentation.restaurant.detail.model.CategoryItemViewData;
import com.androidnerds.doordash.presentation.restaurant.detail.model.StoreDetailViewData;

import javax.inject.Inject;

public class CategoryItemToViewMapper implements Mapper<CategoryItem, CategoryItemViewData> {

    @Inject
    public CategoryItemToViewMapper() {

    }

    @Override
    public CategoryItemViewData map(CategoryItem input) {
        CategoryItemViewData item = new CategoryItemViewData();
        item.setId(input.getId());
        item.setTitle(input.getName());
        item.setDescription(input.getDescription());
        item.setPrice(input.getPriceMonetaryFields().getDisplayString());
        item.setImageUrl(input.getImageUrl());
        return item;
    }
}
