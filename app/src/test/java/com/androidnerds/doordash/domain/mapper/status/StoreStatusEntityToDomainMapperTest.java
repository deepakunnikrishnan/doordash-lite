package com.androidnerds.doordash.domain.mapper.status;

import com.androidnerds.doordash.data.local.entity.StoreStatusEntity;
import com.androidnerds.doordash.data.remote.model.StoreStatusDTO;
import com.androidnerds.doordash.domain.model.StoreStatus;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class StoreStatusEntityToDomainMapperTest {

    @Test
    public void map() {
        StoreStatusEntity entity = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.STORE_STATUS_ENTITY)
                                .getContent(),
                        StoreStatusEntity.class);
        assertNotNull(entity);
        StoreStatusEntitytoDomainMapper dtOtoDomainMapper = new StoreStatusEntitytoDomainMapper();
        StoreStatus domain = dtOtoDomainMapper.map(entity);
        assertNotNull(domain);
    }
}