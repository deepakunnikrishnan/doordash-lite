package com.androidnerds.doordash.data.mapper;

import com.androidnerds.doordash.data.local.entity.StoreStatusEntity;
import com.androidnerds.doordash.data.remote.model.StoreStatusDTO;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.JsonUtils;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class StoreStatusDTOtoEntityMapperTest {

    @Test
    public void map() {
        StoreStatusDTO dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.STORE_STATUS_DTO)
                                .getContent(),
                        StoreStatusDTO.class);
        assertNotNull(dto);
        StoreStatusDTOtoEntityMapper dtOtoEntityMapper = new StoreStatusDTOtoEntityMapper();
        StoreStatusEntity entity = dtOtoEntityMapper.map(dto);
        assertNotNull(entity);
        String content = JsonUtils.toJson(entity);
        System.out.println(content);
    }
}