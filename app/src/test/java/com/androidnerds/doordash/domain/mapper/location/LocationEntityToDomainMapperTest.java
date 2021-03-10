package com.androidnerds.doordash.domain.mapper.location;

import com.androidnerds.doordash.data.local.entity.LocationEntity;
import com.androidnerds.doordash.data.remote.model.LocationDTO;
import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class LocationEntityToDomainMapperTest {

    @Test
    public void map() {
        LocationEntity dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.LOCATION_ENTITY)
                                .getContent(),
                        LocationEntity.class);
        assertNotNull(dto);
        LocationEntitytoDomainMapper entityToDomainMapper = new LocationEntitytoDomainMapper();
        Location domain = entityToDomainMapper.map(dto);
        assertNotNull(domain);
    }
}