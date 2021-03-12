package com.androidnerds.doordash.data.mapper;

import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.data.local.entity.LocationEntity;
import com.androidnerds.doordash.data.remote.model.LocationDTO;

import javax.inject.Inject;


public class LocationDTOtoEntityMapper implements Mapper<LocationDTO, LocationEntity> {

    @Inject
    public LocationDTOtoEntityMapper() {
    }

    @Override
    public LocationEntity map(LocationDTO input) {
        return new LocationEntity(input.getLatitude(), input.getLongitude());
    }
}
