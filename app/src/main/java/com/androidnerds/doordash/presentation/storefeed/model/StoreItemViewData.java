package com.androidnerds.doordash.presentation.storefeed.model;

import java.util.Objects;

public class StoreItemViewData {

    private long id;

    private String name;
    private String description;
    private String priceRange;
    private String averageRating;
    private String ratings;
    private String imageUrl;

    private boolean isOpen;
    private String nextOpenString;
    private boolean isClosingSoon;
    private String closingByString;

    private String deliveryFee;

    private String timeRange;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getNextOpenString() {
        return nextOpenString;
    }

    public void setNextOpenString(String nextOpenString) {
        this.nextOpenString = nextOpenString;
    }

    public boolean isClosingSoon() {
        return isClosingSoon;
    }

    public void setClosingSoon(boolean closingSoon) {
        isClosingSoon = closingSoon;
    }

    public String getClosingByString() {
        return closingByString;
    }

    public void setClosingByString(String closingByString) {
        this.closingByString = closingByString;
    }

    public String getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(String deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StoreItemViewData)) return false;
        StoreItemViewData that = (StoreItemViewData) o;
        return getId() == that.getId() &&
                getRatings() == that.getRatings() &&
                isOpen() == that.isOpen() &&
                isClosingSoon() == that.isClosingSoon() &&
                getName().equals(that.getName()) &&
                getDescription().equals(that.getDescription()) &&
                getPriceRange().equals(that.getPriceRange()) &&
                getAverageRating().equals(that.getAverageRating()) &&
                Objects.equals(getImageUrl(), that.getImageUrl()) &&
                getNextOpenString().equals(that.getNextOpenString()) &&
                getClosingByString().equals(that.getClosingByString()) &&
                Objects.equals(getDeliveryFee(), that.getDeliveryFee()) &&
                Objects.equals(getTimeRange(), that.getTimeRange());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getPriceRange(), getAverageRating(), getRatings(), getImageUrl(), isOpen(), getNextOpenString(), isClosingSoon(), getClosingByString(), getDeliveryFee(), getTimeRange());
    }
}
