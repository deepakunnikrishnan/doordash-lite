package com.androidnerds.doordash.domain.mapper.monetarymetadata;

import com.androidnerds.doordash.data.remote.model.MonetaryMetadataDTO;
import com.androidnerds.doordash.domain.model.MonetaryMetadata;
import com.androidnerds.doordash.core.mapper.Mapper;


public class MonetaryMetadataDTOtoDomainMapper implements Mapper<MonetaryMetadataDTO, MonetaryMetadata> {

    public MonetaryMetadataDTOtoDomainMapper() {
    }

    @Override
    public MonetaryMetadata map(MonetaryMetadataDTO input) {
        MonetaryMetadata metadata = new MonetaryMetadata();
        metadata.setCurrency(input.getCurrency());
        metadata.setDisplayString(input.getDisplayString());
        metadata.setDecimalPlaces(input.getDecimalPlaces());
        metadata.setUnitAmount(input.getUnitAmount());
        return metadata;
    }
}
