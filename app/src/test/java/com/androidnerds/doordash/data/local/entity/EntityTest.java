package com.androidnerds.doordash.data.local.entity;

import org.junit.Test;

import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

public class EntityTest {

    @Test
    public void testFoodItemEntityShouldPassAll() {
        final Class<?> classUnderTest = FoodItemEntity.class;
        Assertions.assertPojoMethodsFor(classUnderTest).areWellImplemented();
    }

    @Test
    public void testLocationEntityShouldPassAll() {
        final Class<?> classUnderTest = LocationEntity.class;
        Assertions.assertPojoMethodsFor(classUnderTest).areWellImplemented();
    }

    @Test
    public void testMenuEntityShouldPassAll() {
        final Class<?> classUnderTest = MenuEntity.class;
        Assertions.assertPojoMethodsFor(classUnderTest).areWellImplemented();
    }

    @Test
    public void testMerchantPromotionEntityShouldPassAll() {
        final Class<?> classUnderTest = MerchantPromotionEntity.class;
        Assertions.assertPojoMethodsFor(classUnderTest).areWellImplemented();
    }

    @Test
    public void testMonetaryMetadataEntityShouldPassAll() {
        final Class<?> classUnderTest = MonetaryMetadataEntity.class;
        Assertions.assertPojoMethodsFor(classUnderTest).areWellImplemented();
    }

    @Test
    public void testStoreEntityShouldPassAll() {
        final Class<?> classUnderTest = StoreEntity.class;
        Assertions.assertPojoMethodsFor(classUnderTest)
                .testing(Method.GETTER,Method.SETTER,Method.CONSTRUCTOR)
                .areWellImplemented();
    }

    @Test
    public void testStoreFeedEntityShouldPassAll() {
        final Class<?> classUnderTest = StoreFeedEntity.class;
        Assertions.assertPojoMethodsFor(classUnderTest).areWellImplemented();
    }

    @Test
    public void testStoreStatusEntityShouldPassAll() {
        final Class<?> classUnderTest = StoreStatusEntity.class;
        Assertions.assertPojoMethodsFor(classUnderTest).areWellImplemented();
    }

}