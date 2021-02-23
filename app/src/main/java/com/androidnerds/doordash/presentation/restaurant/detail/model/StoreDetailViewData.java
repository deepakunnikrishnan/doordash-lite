package com.androidnerds.doordash.presentation.restaurant.detail.model;

import java.util.List;

public class StoreDetailViewData {

    private long id;
    private String name;
    private String description;
    private String averageRating;
    private String ratings;
    private String distance;
    private String priceRange;

    private String headerImageUrl;
    private String profileImageUrl;

    private boolean isOpen;
    private String nextOpenString;
    private boolean isClosingSoon;
    private String closingByString;

    private String deliveryFee;
    private String timeRange;

    private List<CategoryViewData> categories;

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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getHeaderImageUrl() {
        return headerImageUrl;
    }

    public void setHeaderImageUrl(String headerImageUrl) {
        this.headerImageUrl = headerImageUrl;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
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

    public List<CategoryViewData> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryViewData> categories) {
        this.categories = categories;
    }
}
