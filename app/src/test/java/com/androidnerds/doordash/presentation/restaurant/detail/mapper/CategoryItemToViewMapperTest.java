package com.androidnerds.doordash.presentation.restaurant.detail.mapper;

import com.androidnerds.doordash.domain.model.category.CategoryItem;
import com.androidnerds.doordash.presentation.restaurant.detail.model.CategoryItemViewData;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static com.androidnerds.doordash.testconstant.ApiConstants.CATEGORY_ITEM_DOMAIN;
import static org.junit.Assert.*;

public class CategoryItemToViewMapperTest {

    @Test
    public void map() {
        CategoryItemToViewMapper mapper = new CategoryItemToViewMapper();
        CategoryItem categoryItem = new Gson().fromJson(new MockResponseFileReader(CATEGORY_ITEM_DOMAIN).getContent(),
                CategoryItem.class);
        assertNotNull(categoryItem);
        CategoryItemViewData viewData = mapper.map(categoryItem);
        assertNotNull(viewData);
    }

}