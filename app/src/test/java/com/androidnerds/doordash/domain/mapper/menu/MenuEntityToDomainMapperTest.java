package com.androidnerds.doordash.domain.mapper.menu;

import com.androidnerds.doordash.data.local.entity.MenuEntity;
import com.androidnerds.doordash.di.data.MapperModule;
import com.androidnerds.doordash.domain.model.Menu;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MenuEntityToDomainMapperTest {

    @Test
    public void map() {
        MenuEntity dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.MENU_ENTITY)
                                .getContent(),
                        MenuEntity.class);
        assertNotNull(dto);
        MenuEntitytoDomainMapper entityToDomainMapper = new MenuEntitytoDomainMapper(
                MapperModule.provideFoodItemEntityListToDomainMapper(
                        MapperModule.provideFoodItemEntityToDomainMapper()
                )
        );
        Menu domain = entityToDomainMapper.map(dto);
        assertNotNull(domain);
    }
}