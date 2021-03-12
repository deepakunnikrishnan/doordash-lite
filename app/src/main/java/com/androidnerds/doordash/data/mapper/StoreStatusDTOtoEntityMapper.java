package com.androidnerds.doordash.data.mapper;

import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.data.local.entity.StoreStatusEntity;
import com.androidnerds.doordash.data.remote.model.StoreStatusDTO;

import javax.inject.Inject;


public class StoreStatusDTOtoEntityMapper implements Mapper<StoreStatusDTO, StoreStatusEntity> {

    @Inject
    public StoreStatusDTOtoEntityMapper() {

    }

    @Override
    public StoreStatusEntity map(StoreStatusDTO input) {
        StoreStatusEntity storeStatus = new StoreStatusEntity();
        storeStatus.setAsapAvailable(input.isAsapAvailable());
        storeStatus.setPickupAvailable(input.isPickupAvailable());
        storeStatus.setScheduledAvailable(input.isScheduledAvailable());
        storeStatus.setAsapMinuteRange(input.getAsapMinuteRange());
        return storeStatus;
    }
}
