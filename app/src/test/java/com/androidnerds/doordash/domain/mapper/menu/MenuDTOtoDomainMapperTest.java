package com.androidnerds.doordash.domain.mapper.menu;

import com.androidnerds.doordash.data.remote.model.menu.MenuDTO;
import com.androidnerds.doordash.di.MapperModule;
import com.androidnerds.doordash.domain.model.Menu;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MenuDTOtoDomainMapperTest {

    @Test
    public void map() {
        MenuDTO dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.MENU_DTO)
                                .getContent(),
                        MenuDTO.class);
        assertNotNull(dto);
        MenuDTOtoDomainMapper dtOtoDomainMapper = new MenuDTOtoDomainMapper(MapperModule.provideFoodItemDTOListToDomainMapper(MapperModule.provideFoodItemDTOToDomainMapper()));
        Menu domain = dtOtoDomainMapper.map(dto);
        assertNotNull(domain);
    }
}