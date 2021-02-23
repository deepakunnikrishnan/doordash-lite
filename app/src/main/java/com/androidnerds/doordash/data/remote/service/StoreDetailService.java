package com.androidnerds.doordash.data.remote.service;

import com.androidnerds.doordash.data.remote.model.menu.detail.MenuDetailDTO;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StoreDetailService {

    @GET("v1/stores/{id}/menus/?extra=categories&extra=categories.items&extra=categories.items.image_url")
    Single<List<MenuDetailDTO>> getMenu(@Path("id") long id);

}
