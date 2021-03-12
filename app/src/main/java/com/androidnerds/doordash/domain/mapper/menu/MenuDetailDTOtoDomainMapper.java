package com.androidnerds.doordash.domain.mapper.menu;

import com.androidnerds.doordash.core.mapper.ListMapper;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.data.remote.model.FoodItemDTO;
import com.androidnerds.doordash.data.remote.model.category.CategoryDTO;
import com.androidnerds.doordash.data.remote.model.menu.MenuDTO;
import com.androidnerds.doordash.data.remote.model.menu.detail.MenuDetailDTO;
import com.androidnerds.doordash.domain.model.FoodItem;
import com.androidnerds.doordash.domain.model.Menu;
import com.androidnerds.doordash.domain.model.category.Category;
import com.androidnerds.doordash.domain.model.menu.MenuDetail;

import javax.inject.Inject;


public class MenuDetailDTOtoDomainMapper implements Mapper<MenuDetailDTO, MenuDetail> {

    private final ListMapper<CategoryDTO, Category> categoryListMapper;

    @Inject
    public MenuDetailDTOtoDomainMapper(ListMapper<CategoryDTO, Category> categoryListMapper) {
        this.categoryListMapper = categoryListMapper;
    }

    @Override
    public MenuDetail map(MenuDetailDTO input) {
        MenuDetail menuDetail = new MenuDetail();
        menuDetail.setId(input.getId());
        menuDetail.setName(input.getName());
        menuDetail.setSubTitle(input.getSubTitle());
        menuDetail.setCategories(categoryListMapper.map(input.getCategories()));
        return menuDetail;
    }
}
