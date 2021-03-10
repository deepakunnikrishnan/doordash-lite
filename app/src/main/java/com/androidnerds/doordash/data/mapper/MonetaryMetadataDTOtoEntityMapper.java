package com.androidnerds.doordash.data.mapper;

import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.data.local.entity.MonetaryMetadataEntity;
import com.androidnerds.doordash.data.remote.model.MonetaryMetadataDTO;


public class MonetaryMetadataDTOtoEntityMapper implements Mapper<MonetaryMetadataDTO, MonetaryMetadataEntity> {

    public MonetaryMetadataDTOtoEntityMapper(){

    }

    @Override
    public MonetaryMetadataEntity map(MonetaryMetadataDTO input) {
        MonetaryMetadataEntity metadata = new MonetaryMetadataEntity();
        metadata.setCurrency(input.getCurrency());
        metadata.setDisplayString(input.getDisplayString());
        metadata.setDecimalPlaces(input.getDecimalPlaces());
        metadata.setUnitAmount(input.getUnitAmount());
        return metadata;
    }
}
