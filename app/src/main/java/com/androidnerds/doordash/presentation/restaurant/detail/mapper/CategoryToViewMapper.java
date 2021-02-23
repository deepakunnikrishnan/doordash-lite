package com.androidnerds.doordash.presentation.restaurant.detail.mapper;

import com.androidnerds.doordash.core.mapper.ListMapper;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.domain.model.category.Category;
import com.androidnerds.doordash.domain.model.category.CategoryItem;
import com.androidnerds.doordash.presentation.restaurant.detail.model.CategoryItemViewData;
import com.androidnerds.doordash.presentation.restaurant.detail.model.CategoryViewData;

import java.util.Comparator;

public class CategoryToViewMapper implements Mapper<Category, CategoryViewData> {

    private final ListMapper<CategoryItem, CategoryItemViewData> categoryItemViewDataListMapper;

    public CategoryToViewMapper(ListMapper<CategoryItem, CategoryItemViewData> categoryItemViewDataListMapper) {
        this.categoryItemViewDataListMapper = categoryItemViewDataListMapper;
    }

    @Override
    public CategoryViewData map(Category input) {
        CategoryViewData item = new CategoryViewData();
        item.setTitle(input.getTitle());
        item.setSortId(input.getSortId());
        item.setItems(categoryItemViewDataListMapper.map(input.getItems()));
        item.getItems().sort((o1, o2) -> Integer.compare(o1.getSortId(), o2.getSortId()));
        return item;
    }
}
