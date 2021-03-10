package com.androidnerds.doordash.domain.model.category;

import com.androidnerds.doordash.domain.model.MonetaryMetadata;

public class CategoryItem {

    private long id;
    private String name;
    private long sortId;
    private String description;
    private long price;
    private boolean active;
    private MonetaryMetadata priceMonetaryFields;
    private long basePrice;
    private long photoId;
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

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

    public long getSortId() {
        return sortId;
    }

    public void setSortId(long sortId) {
        this.sortId = sortId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public MonetaryMetadata getPriceMonetaryFields() {
        return priceMonetaryFields;
    }

    public void setPriceMonetaryFields(MonetaryMetadata priceMonetaryFields) {
        this.priceMonetaryFields = priceMonetaryFields;
    }

    public long getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(long basePrice) {
        this.basePrice = basePrice;
    }

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }
}
