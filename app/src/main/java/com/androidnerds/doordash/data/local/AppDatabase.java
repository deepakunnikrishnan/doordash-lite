package com.androidnerds.doordash.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.androidnerds.doordash.data.local.dao.StoreDao;
import com.androidnerds.doordash.data.local.dao.StoreFeedDao;
import com.androidnerds.doordash.data.local.entity.StoreEntity;
import com.androidnerds.doordash.data.local.entity.StoreFeedEntity;

@Database(entities = {
        StoreFeedEntity.class,
        StoreEntity.class
}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract StoreDao storeDao();
    public abstract StoreFeedDao storeFeedDao();

}
