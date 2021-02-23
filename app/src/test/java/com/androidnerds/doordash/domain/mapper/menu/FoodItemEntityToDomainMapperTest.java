package com.androidnerds.doordash.domain.mapper.menu;

import com.androidnerds.doordash.data.local.entity.FoodItemEntity;
import com.androidnerds.doordash.data.remote.model.FoodItemDTO;
import com.androidnerds.doordash.domain.model.FoodItem;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class FoodItemEntityToDomainMapperTest {

    @Test
    public void map() {
        FoodItemEntity dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.FOOD_ITEM_ENTITY)
                                .getContent(),
                        FoodItemEntity.class);
        assertNotNull(dto);
        FoodItemEntitytoDomainMapper entityToDomainMapper = new FoodItemEntitytoDomainMapper();
        FoodItem domain = entityToDomainMapper.map(dto);
        assertNotNull(domain);
    }
}