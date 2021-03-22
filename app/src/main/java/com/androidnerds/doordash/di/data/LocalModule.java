package com.androidnerds.doordash.di.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.room.Room;

import com.androidnerds.doordash.data.local.AppDatabase;
import com.androidnerds.doordash.data.local.dao.StoreDao;
import com.androidnerds.doordash.data.local.dao.StoreFeedDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class LocalModule {

    @Singleton
    @Provides
    public static AppDatabase provideAppDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "app-db")
                .build();
    }

    @Provides
    public static StoreDao provideStoreDao(AppDatabase appDatabase) {
        return appDatabase.storeDao();
    }

    @Provides
    public static StoreFeedDao provideStoreFeedDao(AppDatabase appDatabase) {
        return appDatabase.storeFeedDao();
    }

    @Singleton
    @Provides
    public static SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

}
