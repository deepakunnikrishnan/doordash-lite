package com.androidnerds.doordash.domain.mapper.menu;

import com.androidnerds.doordash.core.mapper.ListMapper;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.data.local.entity.FoodItemEntity;
import com.androidnerds.doordash.data.local.entity.MenuEntity;
import com.androidnerds.doordash.data.remote.model.FoodItemDTO;
import com.androidnerds.doordash.data.remote.model.menu.MenuDTO;
import com.androidnerds.doordash.domain.model.FoodItem;
import com.androidnerds.doordash.domain.model.Menu;

import javax.inject.Inject;

public class MenuEntitytoDomainMapper implements Mapper<MenuEntity, Menu> {

    private final ListMapper<FoodItemEntity, FoodItem> foodItemListMapper;

    @Inject
    public MenuEntitytoDomainMapper(ListMapper<FoodItemEntity, FoodItem> foodItemListMapper) {
        this.foodItemListMapper = foodItemListMapper;
    }

    @Override
    public Menu map(MenuEntity input) {
        Menu menu = new Menu();
        menu.setId(input.getId());
        menu.setName(input.getName());
        menu.setSubTitle(input.getSubTitle());
        menu.setCatering(input.isCatering());
        menu.setPopularItems(foodItemListMapper.map(input.getPopularItems()));
        return menu;
    }
}
