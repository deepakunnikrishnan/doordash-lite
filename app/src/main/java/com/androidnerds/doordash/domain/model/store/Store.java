package com.androidnerds.doordash.domain.model.store;

import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.domain.model.Menu;
import com.androidnerds.doordash.domain.model.MerchantPromotion;
import com.androidnerds.doordash.domain.model.MonetaryMetadata;
import com.androidnerds.doordash.domain.model.StoreStatus;

import java.util.List;

public class Store {

    private long id;
    private long businessId;

    private String name;
    private String description;
    private String coverImageUrl;
    private String headerImageUrl;

    private long numRatings;

    private double averageRating;
    private int priceRange;

    private String nextCloseTime;
    private String nextOpenTime;

    private Location location;
    private StoreStatus storeStatus;

    private String url;

    private List<Menu> menuList;

    private String serviceRate;

    private long deliveryFee;
    private MonetaryMetadata deliveryFeeMonetaryFields;

    private long extraSOSDeliveryFee;
    private MonetaryMetadata sosDeliveryFeeMonetaryFields;

    private boolean newlyAdded;
    private boolean consumerSubscriptionEligible;

    private double distanceFromConsumer;

    private List<MerchantPromotion> merchantPromotions;

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public StoreStatus getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(StoreStatus storeStatus) {
        this.storeStatus = storeStatus;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
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

    public MonetaryMetadata getDeliveryFeeMonetaryFields() {
        return deliveryFeeMonetaryFields;
    }

    public void setDeliveryFeeMonetaryFields(MonetaryMetadata deliveryFeeMonetaryFields) {
        this.deliveryFeeMonetaryFields = deliveryFeeMonetaryFields;
    }

    public long getExtraSOSDeliveryFee() {
        return extraSOSDeliveryFee;
    }

    public void setExtraSOSDeliveryFee(long extraSOSDeliveryFee) {
        this.extraSOSDeliveryFee = extraSOSDeliveryFee;
    }

    public MonetaryMetadata getSosDeliveryFeeMonetaryFields() {
        return sosDeliveryFeeMonetaryFields;
    }

    public void setSosDeliveryFeeMonetaryFields(MonetaryMetadata sosDeliveryFeeMonetaryFields) {
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

    public List<MerchantPromotion> getMerchantPromotions() {
        return merchantPromotions;
    }

    public void setMerchantPromotions(List<MerchantPromotion> merchantPromotions) {
        this.merchantPromotions = merchantPromotions;
    }
}


/**
 *
 * data class Store(
 *     val id: Long,
 *     val businessId: Long,
 *     val name: String,
 *     val description: String,
 *     val coverImageUrl: String,
 *     val headerImageUrl: String,
 *     val numRatings: Long,
 *     val averageRating: Double,
 *     val priceRange: Int,
 *     val nextCloseTime: String,
 *     val nextOpenTime: String,
 *     val location: Location,
 *     val status: StoreStatus,
 *     val url: String,
 *     val menus: List<Menu>,
 *     val serviceRate: String?,
 *     val deliveryFee: Long = 0,
 *     val displayDeliveryFee: String,
 *     val deliveryFeeMonetaryFields: MonetaryMetadata,
 *     val extraSOSDeliveryFee: Long,
 *     val sosDeliveryFeeMonetaryFields: MonetaryMetadata,
 *     val isNewlyAdded: Boolean,
 *     val isConsumerSubscriptionEligible: Boolean,
 *     val distanceFromConsumer: Double,
 *     val merchantPromotions: List<MerchantPromotion>,
 *     )
 *
 *
 * data class MonetaryMetadata(
 *     val currency: String,
 *     val displayString: String,
 *     val unitAmount: Long = 0,
 *     val decimalPlaces: Int,
 *
 * )
 *
 * data class Menu(
 *     val id: Long,
 *     val name: String,
 *     val subTitle: String,
 *     val isCatering: Boolean,
 *     val popularItems: List<FoodItem>
 * )
 *
 * data class FoodItem(
 *     val id: Long,
 *     val name: String,
 *     val description: String,
 *     val imageUrl: String,
 *     val price: Long
 * )
 *
 * data class Location(
 *     val latitude: Double,
 *     val longitude: Double,
 * )
 *
 * data class StoreStatus(
 *     val unavailableReason: String?,
 *     val pickupAvailable: Boolean,
 *     val asapAvailable: Boolean,
 *     val scheduledAvailable: Boolean,
 *     val asapMinuteRange: Array<Int>,
 * )
 *
 * data class MerchantPromotion(
 *     val id: Long,
 *     val categoryNewStoreCustomersOnly: Boolean,
 *     val minimumSubTotalMonetaryFields: MonetaryMetadata,
 *     val deliveryFee: Long = 0,
 *     val deliveryFeeMonetaryFields: MonetaryMetadata,
 *     val minimumSubTotal: Long = 0,
 * )



 **/