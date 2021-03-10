package com.androidnerds.doordash.data.remote;

import com.androidnerds.doordash.data.remote.model.FoodItemDTO;
import com.androidnerds.doordash.data.remote.model.LocationDTO;
import com.androidnerds.doordash.data.remote.model.MerchantPromotionDTO;
import com.androidnerds.doordash.data.remote.model.MonetaryMetadataDTO;
import com.androidnerds.doordash.data.remote.model.StoreDTO;
import com.androidnerds.doordash.data.remote.model.StoreFeedDTO;
import com.androidnerds.doordash.data.remote.model.StoreStatusDTO;
import com.androidnerds.doordash.data.remote.model.category.CategoryDTO;
import com.androidnerds.doordash.data.remote.model.category.CategoryItemDTO;
import com.androidnerds.doordash.data.remote.model.menu.MenuDTO;
import com.androidnerds.doordash.data.remote.model.menu.detail.MenuDetailDTO;

import org.junit.Test;

import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

public class DTOTest {


    @Test
    public void testMenuDetailDTOShouldPassAll() {
        final Class<?> classUnderTest = MenuDetailDTO.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testCategoryDTOShouldPassAll() {
        final Class<?> classUnderTest = CategoryDTO.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testCategoryItemDTOShouldPassAll() {
        final Class<?> classUnderTest = CategoryItemDTO.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testFoodItemDTOShouldPassAll() {
        final Class<?> classUnderTest = FoodItemDTO.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testLocationDTOShouldPassAll() {
        final Class<?> classUnderTest = LocationDTO.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testMenuDTOShouldPassAll() {
        final Class<?> classUnderTest = MenuDTO.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testMerchantPromotionDTOShouldPassAll() {
        final Class<?> classUnderTest = MerchantPromotionDTO.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testMonetaryMetadataDTOShouldPassAll() {
        final Class<?> classUnderTest = MonetaryMetadataDTO.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testStoreDTOShouldPassAll() {
        final Class<?> classUnderTest = StoreDTO.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testStoreFeedDTOShouldPassAll() {
        final Class<?> classUnderTest = StoreFeedDTO.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testStoreStatusDTOShouldPassAll() {
        final Class<?> classUnderTest = StoreStatusDTO.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

}
