package com.androidnerds.doordash.domain.mapper.status;

import com.androidnerds.doordash.data.remote.model.StoreStatusDTO;
import com.androidnerds.doordash.domain.model.StoreStatus;
import com.androidnerds.doordash.core.mapper.Mapper;


public class StoreStatusDTOtoDomainMapper implements Mapper<StoreStatusDTO, StoreStatus> {

    public StoreStatusDTOtoDomainMapper() {
    }

    @Override
    public StoreStatus map(StoreStatusDTO input) {
        StoreStatus storeStatus = new StoreStatus();
        storeStatus.setAsapAvailable(input.isAsapAvailable());
        storeStatus.setPickupAvailable(input.isPickupAvailable());
        storeStatus.setScheduledAvailable(input.isScheduledAvailable());
        storeStatus.setAsapMinuteRange(input.getAsapMinuteRange());
        return storeStatus;
    }
}
