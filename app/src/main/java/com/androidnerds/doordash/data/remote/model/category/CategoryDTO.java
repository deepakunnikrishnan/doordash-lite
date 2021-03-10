package com.androidnerds.doordash.data.remote.model.category;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryDTO {

    private String name;
    private String title;
    @SerializedName("subtitle")
    private String subTitle;
    @SerializedName("is_active")
    private boolean active;
    @SerializedName("sort_id")
    private int sortId;
    @SerializedName("is_deactivated")
    private boolean deactivated;
    @SerializedName("items")
    private List<CategoryItemDTO> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public boolean isDeactivated() {
        return deactivated;
    }

    public void setDeactivated(boolean deactivated) {
        this.deactivated = deactivated;
    }

    public List<CategoryItemDTO> getItems() {
        return items;
    }

    public void setItems(List<CategoryItemDTO> items) {
        this.items = items;
    }
}
