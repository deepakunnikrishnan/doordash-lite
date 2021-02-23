package com.androidnerds.doordash.data.remote.model.menu;

import com.androidnerds.doordash.data.remote.model.FoodItemDTO;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MenuDTO implements Serializable {

    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("subTitle")
    private String subTitle;
    @SerializedName("isCatering")
    private boolean catering;
    @SerializedName("popular_items")
    private List<FoodItemDTO> popularItems;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public boolean isCatering() {
        return catering;
    }

    public void setCatering(boolean catering) {
        this.catering = catering;
    }

    public List<FoodItemDTO> getPopularItems() {
        return popularItems;
    }

    public void setPopularItems(List<FoodItemDTO> popularItems) {
        this.popularItems = popularItems;
    }
}
