package com.androidnerds.doordash.presentation.restaurant.detail.model;

import java.util.List;
import java.util.Objects;

public class CategoryViewData {

    private String title;
    private int sortId;
    private List<CategoryItemViewData> items;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public List<CategoryItemViewData> getItems() {
        return items;
    }

    public void setItems(List<CategoryItemViewData> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryViewData)) return false;
        CategoryViewData that = (CategoryViewData) o;
        return getSortId() == that.getSortId() &&
                getTitle().equals(that.getTitle()) &&
                getItems().equals(that.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getSortId(), getItems());
    }
}
