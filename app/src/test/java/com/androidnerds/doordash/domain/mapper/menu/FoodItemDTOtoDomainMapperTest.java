package com.androidnerds.doordash.domain.mapper.menu;

import com.androidnerds.doordash.data.remote.model.FoodItemDTO;
import com.androidnerds.doordash.data.remote.model.menu.MenuDTO;
import com.androidnerds.doordash.di.data.MapperModule;
import com.androidnerds.doordash.domain.mapper.menu.FoodItemDTOtoDomainMapper;
import com.androidnerds.doordash.domain.mapper.menu.MenuDTOtoDomainMapper;
import com.androidnerds.doordash.domain.model.FoodItem;
import com.androidnerds.doordash.domain.model.Menu;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.JsonUtils;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class FoodItemDTOtoDomainMapperTest {

    @Test
    public void map() {
        FoodItemDTO dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.FOOD_ITEM_DTO)
                                .getContent(),
                        FoodItemDTO.class);
        assertNotNull(dto);
        FoodItemDTOtoDomainMapper dtOtoDomainMapper = new FoodItemDTOtoDomainMapper();
        FoodItem domain = dtOtoDomainMapper.map(dto);
        assertNotNull(domain);
    }
}