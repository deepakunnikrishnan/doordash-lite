package com.androidnerds.doordash.data.mapper;

import com.androidnerds.doordash.core.mapper.ListMapper;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.data.local.entity.FoodItemEntity;
import com.androidnerds.doordash.data.local.entity.MenuEntity;
import com.androidnerds.doordash.data.remote.model.FoodItemDTO;
import com.androidnerds.doordash.data.remote.model.menu.MenuDTO;

import javax.inject.Inject;


public class MenuDTOtoEntityMapper implements Mapper<MenuDTO, MenuEntity> {

    private final ListMapper<FoodItemDTO, FoodItemEntity> foodItemListMapper;

    @Inject
    public MenuDTOtoEntityMapper(ListMapper<FoodItemDTO, FoodItemEntity> foodItemListMapper) {
        this.foodItemListMapper = foodItemListMapper;
    }

    @Override
    public MenuEntity map(MenuDTO input) {
        MenuEntity menu = new MenuEntity();
        menu.setId(input.getId());
        menu.setName(input.getName());
        menu.setSubTitle(input.getSubTitle());
        menu.setCatering(input.isCatering());
        menu.setPopularItems(foodItemListMapper.map(input.getPopularItems()));
        return menu;
    }
}
