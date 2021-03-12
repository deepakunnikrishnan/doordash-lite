package com.androidnerds.doordash.domain.mapper.menu;

import com.androidnerds.doordash.data.remote.model.menu.detail.MenuDetailDTO;
import com.androidnerds.doordash.di.MapperModule;
import com.androidnerds.doordash.domain.model.menu.MenuDetail;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MenuDetailDTOtoDomainMapperTest {

    @Test
    public void map() {
        MenuDetailDTO dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.MENU_DETAIL_DTO)
                                .getContent(),
                        MenuDetailDTO.class);
        assertNotNull(dto);
        MenuDetailDTOtoDomainMapper dtOtoDomainMapper = new MenuDetailDTOtoDomainMapper(
                MapperModule.provideCategoryDTOListToDomainMapper(
                        MapperModule.provideCategoryDTOtoDomainMapper(
                                MapperModule.provideCategoryItemDTOListToDomainMapper(
                                        MapperModule.provideCategoryItemDTOtoDomainMapper(
                                                MapperModule.provideMonetaryMetadataDTOtoDomainMapper()
                                        )
                                )
                        )
                )
        );
        MenuDetail domain = dtOtoDomainMapper.map(dto);
        assertNotNull(domain);
    }
}