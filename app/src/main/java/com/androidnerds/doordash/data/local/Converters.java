package com.androidnerds.doordash.data.local;

import androidx.room.TypeConverter;

import com.androidnerds.doordash.data.local.entity.FoodItemEntity;
import com.androidnerds.doordash.data.local.entity.MenuEntity;
import com.androidnerds.doordash.data.local.entity.MerchantPromotionEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Converters {

    @TypeConverter
    public static int[] fromString(String value) {
        return new Gson().fromJson(value, int[].class);
    }

    @TypeConverter
    public static String fromArrayList(int[] array) {
        Gson gson = new Gson();
        return gson.toJson(array);
    }

    @TypeConverter
    public static List<MenuEntity> getMenuEntityString(String value) {
        Type collectionType = new TypeToken<ArrayList<MenuEntity>>(){}.getType();
        return new Gson().fromJson(value, collectionType);
    }

    @TypeConverter
    public static String convertMenuListToString(List<MenuEntity> menuEntities) {
        return new Gson().toJson(menuEntities);
    }

    @TypeConverter
    public static List<FoodItemEntity> getFoodItemsEntityString(String value) {
        Type collectionType = new TypeToken<ArrayList<FoodItemEntity>>(){}.getType();
        return new Gson().fromJson(value, collectionType);
    }

    @TypeConverter
    public static String convertFoodItemListToString(List<FoodItemEntity> foodItemEntities) {
        return new Gson().toJson(foodItemEntities);
    }

    @TypeConverter
    public static List<MerchantPromotionEntity> getMerchantPromotionsListToString(String value) {
        Type collectionType = new TypeToken<ArrayList<MerchantPromotionEntity>>(){}.getType();
        return new Gson().fromJson(value, collectionType);
    }

    @TypeConverter
    public static String convertMerchantPromotionListToString(List<MerchantPromotionEntity> merchantPromotionEntities) {
        return new Gson().toJson(merchantPromotionEntities);
    }
}
