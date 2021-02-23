package com.androidnerds.doordash.data.remote.model;

import com.androidnerds.doordash.data.remote.model.menu.MenuDTO;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class StoreDTO implements Serializable {

    @SerializedName("id")
    private long id;
    @SerializedName("business_id")
    private long businessId;

    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("cover_img_url")
    private String coverImageUrl;
    @SerializedName("header_img_url")
    private String headerImageUrl;

    @SerializedName("num_ratings")
    private long numRatings;

    @SerializedName("average_rating")
    private double averageRating;
    @SerializedName("price_range")
    private int priceRange;

    @SerializedName("next_close_time")
    private String nextCloseTime;
    @SerializedName("next_open_time")
    private String nextOpenTime;

    @SerializedName("location")
    private LocationDTO location;
    @SerializedName("status")
    private StoreStatusDTO storeStatus;

    @SerializedName("url")
    private String url;

    @SerializedName("menus")
    private List<MenuDTO> menuList;

    @SerializedName("service_rate")
    private String serviceRate;

    @SerializedName("delivery_fee")
    private long deliveryFee;
    @SerializedName("display_delivery_fee")
    private String displayDeliveryFee;
    @SerializedName("delivery_fee_monetary_fields")
    private MonetaryMetadataDTO deliveryFeeMonetaryFields;

    @SerializedName("extra_sos_delivery_fee")
    private long extraSOSDeliveryFee;
    @SerializedName("extra_sos_delivery_fee_monetary_fields")
    private MonetaryMetadataDTO sosDeliveryFeeMonetaryFields;

    @SerializedName("is_newly_added")
    private boolean newlyAdded;
    @SerializedName("is_consumer_subscription_eligible")
    private boolean consumerSubscriptionEligible;

    @SerializedName("distance_from_consumer")
    private double distanceFromConsumer;

    @SerializedName("merchant_promotions")
    private List<MerchantPromotionDTO> merchantPromotions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
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

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getHeaderImageUrl() {
        return headerImageUrl;
    }

    public void setHeaderImageUrl(String headerImageUrl) {
        this.headerImageUrl = headerImageUrl;
    }

    public long getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(long numRatings) {
        this.numRatings = numRatings;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public int getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(int priceRange) {
        this.priceRange = priceRange;
    }

    public String getNextCloseTime() {
        return nextCloseTime;
    }

    public void setNextCloseTime(String nextCloseTime) {
        this.nextCloseTime = nextCloseTime;
    }

    public String getNextOpenTime() {
        return nextOpenTime;
    }

    public void setNextOpenTime(String nextOpenTime) {
        this.nextOpenTime = nextOpenTime;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    public StoreStatusDTO getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(StoreStatusDTO storeStatus) {
        this.storeStatus = storeStatus;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MenuDTO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuDTO> menuList) {
        this.menuList = menuList;
    }

    public String getServiceRate() {
        return serviceRate;
    }

    public void setServiceRate(String serviceRate) {
        this.serviceRate = serviceRate;
    }

    public long getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(long deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public MonetaryMetadataDTO getDeliveryFeeMonetaryFields() {
        return deliveryFeeMonetaryFields;
    }

    public void setDeliveryFeeMonetaryFields(MonetaryMetadataDTO deliveryFeeMonetaryFields) {
        this.deliveryFeeMonetaryFields = deliveryFeeMonetaryFields;
    }

    public long getExtraSOSDeliveryFee() {
        return extraSOSDeliveryFee;
    }

    public void setExtraSOSDeliveryFee(long extraSOSDeliveryFee) {
        this.extraSOSDeliveryFee = extraSOSDeliveryFee;
    }

    public MonetaryMetadataDTO getSosDeliveryFeeMonetaryFields() {
        return sosDeliveryFeeMonetaryFields;
    }

    public void setSosDeliveryFeeMonetaryFields(MonetaryMetadataDTO sosDeliveryFeeMonetaryFields) {
        this.sosDeliveryFeeMonetaryFields = sosDeliveryFeeMonetaryFields;
    }

    public boolean isNewlyAdded() {
        return newlyAdded;
    }

    public void setNewlyAdded(boolean newlyAdded) {
        this.newlyAdded = newlyAdded;
    }

    public boolean isConsumerSubscriptionEligible() {
        return consumerSubscriptionEligible;
    }

    public void setConsumerSubscriptionEligible(boolean consumerSubscriptionEligible) {
        this.consumerSubscriptionEligible = consumerSubscriptionEligible;
    }

    public double getDistanceFromConsumer() {
        return distanceFromConsumer;
    }

    public void setDistanceFromConsumer(double distanceFromConsumer) {
        this.distanceFromConsumer = distanceFromConsumer;
    }

    public List<MerchantPromotionDTO> getMerchantPromotions() {
        return merchantPromotions;
    }

    public void setMerchantPromotions(List<MerchantPromotionDTO> merchantPromotions) {
        this.merchantPromotions = merchantPromotions;
    }

    public String getDisplayDeliveryFee() {
        return displayDeliveryFee;
    }

    public void setDisplayDeliveryFee(String displayDeliveryFee) {
        this.displayDeliveryFee = displayDeliveryFee;
    }
}
