package com.androidnerds.doordash.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.androidnerds.doordash.data.local.entity.StoreFeedEntity;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface StoreFeedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertStoreFeed(StoreFeedEntity storeFeed);
    @Update
    Completable updateStoreFeed(StoreFeedEntity storeFeed);
    @Delete
    Completable deleteStoreFeed(StoreFeedEntity storeFeed);
    @Query("SELECT * FROM store_feed")
    Maybe<StoreFeedEntity> getStoreFeed();
    @Query("SELECT COUNT(*) FROM store_feed")
    Single<Integer> getStoreFeedCount();

}
