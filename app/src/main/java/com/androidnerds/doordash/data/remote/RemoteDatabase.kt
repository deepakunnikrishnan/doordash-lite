package com.androidnerds.doordash.data.remote

import com.androidnerds.doordash.storefeed.data.remote.StoreFeedDao
import retrofit2.Retrofit

object RemoteDatabase {

    private fun provideRetrofitClient(): Retrofit =
        Retrofit.Builder().baseUrl("https://api.doordash.com/v1").build();

    fun provideStoreFeedDao(): StoreFeedDao =
        provideRetrofitClient().create(StoreFeedDao::class.java)
}