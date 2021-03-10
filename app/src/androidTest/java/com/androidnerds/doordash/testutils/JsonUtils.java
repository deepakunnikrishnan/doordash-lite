package com.androidnerds.doordash.testutils;

import com.androidnerds.doordash.data.local.entity.StoreEntity;
import com.google.gson.Gson;

public class JsonUtils {

    public static StoreEntity getStore(String content) {
        Gson gson = new Gson();
        return gson.fromJson(content, StoreEntity.class);
    }
}
