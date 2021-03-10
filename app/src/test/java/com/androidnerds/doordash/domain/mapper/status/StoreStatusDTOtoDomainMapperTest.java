package com.androidnerds.doordash.domain.mapper.status;

import com.androidnerds.doordash.data.remote.model.StoreStatusDTO;
import com.androidnerds.doordash.domain.model.StoreStatus;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class StoreStatusDTOtoDomainMapperTest {

    @Test
    public void map() {
        StoreStatusDTO dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.STORE_STATUS_DTO)
                                .getContent(),
                        StoreStatusDTO.class);
        assertNotNull(dto);
        StoreStatusDTOtoDomainMapper dtOtoDomainMapper = new StoreStatusDTOtoDomainMapper();
        StoreStatus domain = dtOtoDomainMapper.map(dto);
        assertNotNull(domain);

    }
}