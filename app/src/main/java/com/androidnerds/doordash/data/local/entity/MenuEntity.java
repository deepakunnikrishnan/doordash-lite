package com.androidnerds.doordash.data.local.entity;

import java.util.List;
import java.util.Objects;

public class MenuEntity {
    private long id;
    private String name;
    private String subTitle;
    private boolean catering;
    private List<FoodItemEntity> popularItems;

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

    public List<FoodItemEntity> getPopularItems() {
        return popularItems;
    }

    public void setPopularItems(List<FoodItemEntity> popularItems) {
        this.popularItems = popularItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuEntity)) return false;
        MenuEntity that = (MenuEntity) o;
        return getId() == that.getId() &&
                isCatering() == that.isCatering() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getSubTitle(), that.getSubTitle()) &&
                Objects.equals(getPopularItems(), that.getPopularItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSubTitle(), isCatering(), getPopularItems());
    }

    @Override
    public String toString() {
        return "MenuEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", catering=" + catering +
                ", popularItems=" + popularItems +
                '}';
    }
}
