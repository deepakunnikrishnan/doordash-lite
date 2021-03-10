package com.androidnerds.doordash.data.mapper;

import com.androidnerds.doordash.data.local.entity.MenuEntity;
import com.androidnerds.doordash.data.remote.model.menu.MenuDTO;
import com.androidnerds.doordash.di.data.MapperModule;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MenuDTOtoEntityMapperTest {

    @Test
    public void map() {
        MenuDTO dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.MENU_DTO)
                                .getContent(),
                        MenuDTO.class);
        assertNotNull(dto);
        MenuDTOtoEntityMapper dtOtoEntityMapper = new MenuDTOtoEntityMapper(MapperModule.provideFoodItemDTOListToEntityMapper(
                MapperModule.provideFoodItemDTOToEntityMapper()
        ));
        MenuEntity entity = dtOtoEntityMapper.map(dto);
        assertNotNull(entity);
    }
}