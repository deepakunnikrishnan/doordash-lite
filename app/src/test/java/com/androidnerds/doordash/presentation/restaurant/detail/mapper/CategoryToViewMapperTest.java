package com.androidnerds.doordash.presentation.restaurant.detail.mapper;

import com.androidnerds.doordash.di.PresentationModule;
import com.androidnerds.doordash.domain.model.category.Category;
import com.androidnerds.doordash.presentation.restaurant.detail.model.CategoryViewData;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static com.androidnerds.doordash.testconstant.ApiConstants.CATEGORY_DOMAIN;
import static org.junit.Assert.assertNotNull;

public class CategoryToViewMapperTest {

    @Test
    public void map() {
        CategoryToViewMapper mapper = new CategoryToViewMapper(PresentationModule.provideCategoryItemListMapper(PresentationModule.provideCategoryItemMapper()));
        Category category = new Gson().fromJson(new MockResponseFileReader(CATEGORY_DOMAIN).getContent(),
                Category.class);
        assertNotNull(category);
        CategoryViewData viewData = mapper.map(category);
        assertNotNull(viewData);
    }
}