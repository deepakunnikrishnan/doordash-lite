package com.androidnerds.doordash.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.androidnerds.doordash.data.local.entity.StoreEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface StoreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertStores(List<StoreEntity> storeEntities);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertStore(StoreEntity storeEntity);
    @Update
    Completable updateStore(StoreEntity storeEntity);
    @Delete
    Completable deleteStore(StoreEntity storeEntity);
    @Query("DELETE FROM store")
    Completable clearAll();

    @Query("SELECT * FROM store")
    Single<List<StoreEntity>> getAllStores();

    @Query("SELECT * FROM store WHERE id = :id")
    Single<StoreEntity> getStore(long id);
}
