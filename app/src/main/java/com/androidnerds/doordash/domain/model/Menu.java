package com.androidnerds.doordash.domain.model;

import java.util.List;

public class Menu {

    private long id;
    private String name;
    private String subTitle;
    private boolean catering;
    private List<FoodItem> popularItems;

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

    public List<FoodItem> getPopularItems() {
        return popularItems;
    }

    public void setPopularItems(List<FoodItem> popularItems) {
        this.popularItems = popularItems;
    }
}
