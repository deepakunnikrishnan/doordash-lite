package com.androidnerds.doordash.data.remote.model.category;

import com.androidnerds.doordash.data.remote.model.MonetaryMetadataDTO;
import com.google.gson.annotations.SerializedName;

public class CategoryItemDTO {

    private long id;
    private String name;
    @SerializedName("sort_id")
    private long sortId;
    private String description;
    private long price;
    private boolean active;
    @SerializedName("price_monetary_fields")
    private MonetaryMetadataDTO priceMonetaryFields;
    private long basePrice;
    @SerializedName("photo_id")
    private long photoId;
    @SerializedName("image_url")
    private String imageUrl;

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

    public MonetaryMetadataDTO getPriceMonetaryFields() {
        return priceMonetaryFields;
    }

    public void setPriceMonetaryFields(MonetaryMetadataDTO priceMonetaryFields) {
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
