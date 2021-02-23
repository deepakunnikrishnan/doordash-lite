package com.androidnerds.doordash.data.mapper;

import com.androidnerds.doordash.data.local.entity.MonetaryMetadataEntity;
import com.androidnerds.doordash.data.remote.model.MonetaryMetadataDTO;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.JsonUtils;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MonetaryMetadataDTOtoEntityMapperTest {

    @Test
    public void map() {
        MonetaryMetadataDTO dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.MONETARY_METADATA_DTO)
                                .getContent(),
                        MonetaryMetadataDTO.class);
        assertNotNull(dto);
        MonetaryMetadataDTOtoEntityMapper dtOtoEntityMapper = new MonetaryMetadataDTOtoEntityMapper();
        MonetaryMetadataEntity entity = dtOtoEntityMapper.map(dto);
        assertNotNull(entity);
        String content = JsonUtils.toJson(entity);
        System.out.println(content);
    }
}