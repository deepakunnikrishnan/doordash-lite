package com.androidnerds.doordash.presentation.restaurant.detail.model;

import java.util.Objects;

public class CategoryItemViewData {

    private long id;
    private int sortId;
    private String title;
    private String description;
    private String price;
    private String imageUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryItemViewData)) return false;
        CategoryItemViewData that = (CategoryItemViewData) o;
        return getId() == that.getId() &&
                getSortId() == that.getSortId() &&
                getTitle().equals(that.getTitle()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                getPrice().equals(that.getPrice()) &&
                Objects.equals(getImageUrl(), that.getImageUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSortId(), getTitle(), getDescription(), getPrice(), getImageUrl());
    }
}
