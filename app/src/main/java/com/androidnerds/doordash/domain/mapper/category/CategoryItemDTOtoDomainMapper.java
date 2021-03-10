package com.androidnerds.doordash.domain.mapper.category;

import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.data.remote.model.MonetaryMetadataDTO;
import com.androidnerds.doordash.data.remote.model.category.CategoryItemDTO;
import com.androidnerds.doordash.domain.model.MonetaryMetadata;
import com.androidnerds.doordash.domain.model.category.CategoryItem;

import javax.inject.Inject;


public class CategoryItemDTOtoDomainMapper implements Mapper<CategoryItemDTO, CategoryItem> {

    private final Mapper<MonetaryMetadataDTO, MonetaryMetadata> monetaryMetadataMapper;

    @Inject
    public CategoryItemDTOtoDomainMapper(Mapper<MonetaryMetadataDTO, MonetaryMetadata> monetaryMetadataMapper) {
        this.monetaryMetadataMapper = monetaryMetadataMapper;
    }


    @Override
    public CategoryItem map(CategoryItemDTO input) {
        CategoryItem categoryItem = new CategoryItem();
        categoryItem.setId(input.getId());
        categoryItem.setName(input.getName());
        categoryItem.setDescription(input.getDescription());
        categoryItem.setPhotoId(input.getPhotoId());
        categoryItem.setImageUrl(input.getImageUrl());
        categoryItem.setBasePrice(input.getBasePrice());
        categoryItem.setActive(input.isActive());
        categoryItem.setPrice(input.getPrice());
        categoryItem.setPriceMonetaryFields(monetaryMetadataMapper.map(input.getPriceMonetaryFields()));
        return categoryItem;
    }
}
