package com.androidnerds.doordash.domain.mapper.location;

import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.data.local.entity.LocationEntity;
import com.androidnerds.doordash.data.remote.model.LocationDTO;
import com.androidnerds.doordash.domain.model.Location;

import javax.inject.Inject;

public class LocationEntitytoDomainMapper implements Mapper<LocationEntity, Location> {

    @Inject
    public LocationEntitytoDomainMapper() {
    }

    @Override
    public Location map(LocationEntity input) {
        return new Location(input.getLatitude(), input.getLongitude());
    }
}
