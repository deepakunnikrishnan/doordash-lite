package com.androidnerds.doordash.domain.mapper.category;

import com.androidnerds.doordash.data.remote.model.category.CategoryDTO;
import com.androidnerds.doordash.di.MapperModule;
import com.androidnerds.doordash.domain.model.category.Category;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CategoryDTOtoDomainMapperTest {

    @Test
    public void map() {
        CategoryDTO dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.CATEGORY_DTO)
                                .getContent(),
                        CategoryDTO.class);
        assertNotNull(dto);
        CategoryDTOtoDomainMapper dtOtoDomainMapper = new CategoryDTOtoDomainMapper(MapperModule.provideCategoryItemDTOListToDomainMapper(
                MapperModule.provideCategoryItemDTOtoDomainMapper(
                        MapperModule.provideMonetaryMetadataDTOtoDomainMapper()
                )
        ));
        Category domain = dtOtoDomainMapper.map(dto);
        assertNotNull(domain);
    }
}