package com.androidnerds.doordash.domain.mapper.menu;

import com.androidnerds.doordash.data.remote.model.FoodItemDTO;
import com.androidnerds.doordash.data.remote.model.menu.MenuDTO;
import com.androidnerds.doordash.domain.model.FoodItem;
import com.androidnerds.doordash.domain.model.Menu;
import com.androidnerds.doordash.core.mapper.ListMapper;
import com.androidnerds.doordash.core.mapper.Mapper;

import javax.inject.Inject;


public class MenuDTOtoDomainMapper implements Mapper<MenuDTO, Menu> {

    private final ListMapper<FoodItemDTO, FoodItem> foodItemListMapper;

    @Inject
    public MenuDTOtoDomainMapper(ListMapper<FoodItemDTO, FoodItem> foodItemListMapper) {
        this.foodItemListMapper = foodItemListMapper;
    }

    @Override
    public Menu map(MenuDTO input) {
        Menu menu = new Menu();
        menu.setId(input.getId());
        menu.setName(input.getName());
        menu.setSubTitle(input.getSubTitle());
        menu.setCatering(input.isCatering());
        menu.setPopularItems(foodItemListMapper.map(input.getPopularItems()));
        return menu;
    }
}
