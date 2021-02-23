package com.androidnerds.doordash.domain.mapper.location;

import com.androidnerds.doordash.data.remote.model.LocationDTO;
import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class LocationDTOtoDomainMapperTest {

    @Test
    public void map() {
        LocationDTO dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.LOCATION_DTO)
                                .getContent(),
                        LocationDTO.class);
        assertNotNull(dto);
        LocationDTOtoDomainMapper dtOtoDomainMapper = new LocationDTOtoDomainMapper();
        Location domain = dtOtoDomainMapper.map(dto);
        assertNotNull(domain);
    }
}