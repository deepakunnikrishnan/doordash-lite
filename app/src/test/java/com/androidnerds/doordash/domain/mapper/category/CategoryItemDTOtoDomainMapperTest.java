package com.androidnerds.doordash.domain.mapper.category;

import com.androidnerds.doordash.data.remote.model.category.CategoryItemDTO;
import com.androidnerds.doordash.di.data.MapperModule;
import com.androidnerds.doordash.domain.model.category.CategoryItem;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CategoryItemDTOtoDomainMapperTest {

    @Test
    public void map() {
        CategoryItemDTO dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.CATEGORY_ITEM_DTO)
                                .getContent(),
                        CategoryItemDTO.class);
        assertNotNull(dto);
        CategoryItemDTOtoDomainMapper dtOtoDomainMapper = new CategoryItemDTOtoDomainMapper(MapperModule.provideMonetaryMetadataDTOtoDomainMapper());
        CategoryItem domain = dtOtoDomainMapper.map(dto);
        assertNotNull(domain);
    }
}