package com.androidnerds.doordash.data.mapper;

import com.androidnerds.doordash.data.local.entity.LocationEntity;
import com.androidnerds.doordash.data.remote.model.LocationDTO;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class LocationDTOtoEntityMapperTest {

    @Test
    public void map() {
        LocationDTO dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.LOCATION_DTO)
                                .getContent(),
                        LocationDTO.class);
        assertNotNull(dto);
        LocationDTOtoEntityMapper dtOtoEntityMapper = new LocationDTOtoEntityMapper();
        LocationEntity entity = dtOtoEntityMapper.map(dto);
        assertNotNull(entity);
    }
}