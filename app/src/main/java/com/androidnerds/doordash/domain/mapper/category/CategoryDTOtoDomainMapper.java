package com.androidnerds.doordash.domain.mapper.category;

import com.androidnerds.doordash.core.mapper.ListMapper;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.data.remote.model.category.CategoryDTO;
import com.androidnerds.doordash.data.remote.model.category.CategoryItemDTO;
import com.androidnerds.doordash.data.remote.model.menu.detail.MenuDetailDTO;
import com.androidnerds.doordash.domain.model.category.Category;
import com.androidnerds.doordash.domain.model.category.CategoryItem;
import com.androidnerds.doordash.domain.model.menu.MenuDetail;

import javax.inject.Inject;


public class CategoryDTOtoDomainMapper implements Mapper<CategoryDTO, Category> {

    private final ListMapper<CategoryItemDTO, CategoryItem> categoryItemListMapper;

    @Inject
    public CategoryDTOtoDomainMapper(ListMapper<CategoryItemDTO, CategoryItem> categoryItemListMapper) {
        this.categoryItemListMapper = categoryItemListMapper;
    }

    @Override
    public Category map(CategoryDTO input) {
        Category category = new Category();
        category.setName(input.getName());
        category.setTitle(input.getTitle());
        category.setSubTitle(input.getSubTitle());
        category.setSortId(input.getSortId());
        category.setActive(input.isActive());
        category.setDeactivated(input.isDeactivated());
        category.setItems(categoryItemListMapper.map(input.getItems()));
        return category;
    }
}
