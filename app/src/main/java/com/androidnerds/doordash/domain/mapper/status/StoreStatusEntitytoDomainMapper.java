package com.androidnerds.doordash.domain.mapper.status;

import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.data.local.entity.StoreStatusEntity;
import com.androidnerds.doordash.data.remote.model.StoreStatusDTO;
import com.androidnerds.doordash.domain.model.StoreStatus;

public class StoreStatusEntitytoDomainMapper implements Mapper<StoreStatusEntity, StoreStatus> {

    public StoreStatusEntitytoDomainMapper() {
    }

    @Override
    public StoreStatus map(StoreStatusEntity input) {
        StoreStatus storeStatus = new StoreStatus();
        storeStatus.setAsapAvailable(input.isAsapAvailable());
        storeStatus.setPickupAvailable(input.isPickupAvailable());
        storeStatus.setScheduledAvailable(input.isScheduledAvailable());
        storeStatus.setAsapMinuteRange(input.getAsapMinuteRange());
        return storeStatus;
    }
}
