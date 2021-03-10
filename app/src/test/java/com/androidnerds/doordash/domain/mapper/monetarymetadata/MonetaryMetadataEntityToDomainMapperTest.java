package com.androidnerds.doordash.domain.mapper.monetarymetadata;

import com.androidnerds.doordash.data.local.entity.MonetaryMetadataEntity;
import com.androidnerds.doordash.domain.model.MonetaryMetadata;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MonetaryMetadataEntityToDomainMapperTest {

    @Test
    public void map() {
        MonetaryMetadataEntity dto = new Gson()
                .fromJson(new MockResponseFileReader(ApiConstants.MONETARY_METADATA_ENTITY)
                                .getContent(),
                        MonetaryMetadataEntity.class);
        assertNotNull(dto);
        MonetaryMetadataEntitytoDomainMapper entityToDomainMapper = new MonetaryMetadataEntitytoDomainMapper();
        MonetaryMetadata domain = entityToDomainMapper.map(dto);
        assertNotNull(domain);
    }
}