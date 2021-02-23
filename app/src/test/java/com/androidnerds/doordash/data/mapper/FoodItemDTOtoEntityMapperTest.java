package com.androidnerds.doordash.data.mapper;

import com.androidnerds.doordash.data.local.entity.FoodItemEntity;
import com.androidnerds.doordash.data.remote.model.FoodItemDTO;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class FoodItemDTOtoEntityMapperTest {

    @Test
    public void map() {
        FoodItemDTO dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.FOOD_ITEM_DTO)
                                .getContent(),
                        FoodItemDTO.class);
        assertNotNull(dto);
        FoodItemDTOtoEntityMapper dtOtoEntityMapper = new FoodItemDTOtoEntityMapper();
        FoodItemEntity entity = dtOtoEntityMapper.map(dto);
        assertNotNull(entity);
    }
}