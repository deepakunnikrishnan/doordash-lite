package com.androidnerds.doordash.domain;

import com.androidnerds.doordash.domain.model.FoodItem;
import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.domain.model.Menu;
import com.androidnerds.doordash.domain.model.MerchantPromotion;
import com.androidnerds.doordash.domain.model.MonetaryMetadata;
import com.androidnerds.doordash.domain.model.StoreFeed;
import com.androidnerds.doordash.domain.model.StoreStatus;
import com.androidnerds.doordash.domain.model.category.Category;
import com.androidnerds.doordash.domain.model.category.CategoryItem;
import com.androidnerds.doordash.domain.model.menu.MenuDetail;
import com.androidnerds.doordash.domain.model.store.Store;
import com.androidnerds.doordash.domain.model.store.StoreDetail;

import org.junit.Test;

import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

public class DomainModelTest {

    @Test
    public void testStoreDetailShouldPassAll() {
        final Class<?> classUnderTest = StoreDetail.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testMenuDetailShouldPassAll() {
        final Class<?> classUnderTest = MenuDetail.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testCategoryShouldPassAll() {
        final Class<?> classUnderTest = Category.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testCategoryItemShouldPassAll() {
        final Class<?> classUnderTest = CategoryItem.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testFoodItemShouldPassAll() {
        final Class<?> classUnderTest = FoodItem.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testLocationShouldPassAll() {
        final Class<?> classUnderTest = Location.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testMenuShouldPassAll() {
        final Class<?> classUnderTest = Menu.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testMerchantPromotionShouldPassAll() {
        final Class<?> classUnderTest = MerchantPromotion.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testMonetaryMetadataShouldPassAll() {
        final Class<?> classUnderTest = MonetaryMetadata.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testStoreShouldPassAll() {
        final Class<?> classUnderTest = Store.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testStoreFeedShouldPassAll() {
        final Class<?> classUnderTest = StoreFeed.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testStoreStatusShouldPassAll() {
        final Class<?> classUnderTest = StoreStatus.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR)
                .areWellImplemented();
    }
}
