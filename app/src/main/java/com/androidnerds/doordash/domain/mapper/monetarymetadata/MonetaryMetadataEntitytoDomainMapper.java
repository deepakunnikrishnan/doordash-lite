package com.androidnerds.doordash.domain.mapper.monetarymetadata;

import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.data.local.entity.MonetaryMetadataEntity;
import com.androidnerds.doordash.data.remote.model.MonetaryMetadataDTO;
import com.androidnerds.doordash.domain.model.MonetaryMetadata;


public class MonetaryMetadataEntitytoDomainMapper implements Mapper<MonetaryMetadataEntity, MonetaryMetadata> {

    public MonetaryMetadataEntitytoDomainMapper() {
    }

    @Override
    public MonetaryMetadata map(MonetaryMetadataEntity input) {
        MonetaryMetadata metadata = new MonetaryMetadata();
        metadata.setCurrency(input.getCurrency());
        metadata.setDisplayString(input.getDisplayString());
        metadata.setDecimalPlaces(input.getDecimalPlaces());
        metadata.setUnitAmount(input.getUnitAmount());
        return metadata;
    }
}
