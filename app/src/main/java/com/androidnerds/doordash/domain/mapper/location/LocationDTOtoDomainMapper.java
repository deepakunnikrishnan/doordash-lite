package com.androidnerds.doordash.domain.mapper.location;

import com.androidnerds.doordash.data.remote.model.LocationDTO;
import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.core.mapper.Mapper;

import javax.inject.Inject;


public class LocationDTOtoDomainMapper implements Mapper<LocationDTO, Location> {

    @Inject
    public LocationDTOtoDomainMapper() {
    }

    @Override
    public Location map(LocationDTO input) {
        return new Location(input.getLatitude(), input.getLongitude());
    }
}
