package com.androidnerds.doordash.di.data;

import android.content.Context;

import androidx.room.Room;

import com.androidnerds.doordash.data.local.AppDatabase;
import com.androidnerds.doordash.data.local.dao.StoreDao;
import com.androidnerds.doordash.data.local.dao.StoreFeedDao;

public class LocalModule {

    private static AppDatabase appDatabase;

    public static AppDatabase provideAppDatabase(Context context) {
        if(null == appDatabase) {
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, "app-db")
                    .build();
        }
        return appDatabase;
    }

    public static StoreDao provideStoreDao(AppDatabase appDatabase) {
        return appDatabase.storeDao();
    }

    public static StoreFeedDao provideStoreFeedDao(AppDatabase appDatabase) {
        return appDatabase.storeFeedDao();
    }
}
