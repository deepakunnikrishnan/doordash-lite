package com.androidnerds.doordash.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(
        tableName = "store",
        indices = {@Index(value = {"id"},unique = true)}
)
public class StoreEntity {

    @PrimaryKey
    @ColumnInfo
    private long id;
    @ColumnInfo
    private long businessId;

    @ColumnInfo
    private String name;
    @ColumnInfo
    private String description;
    @ColumnInfo
    private String coverImageUrl;
    @ColumnInfo
    private String headerImageUrl;

    @ColumnInfo
    private long numRatings;

    @ColumnInfo
    private double averageRating;
    @ColumnInfo
    private int priceRange;

    @ColumnInfo
    private String nextCloseTime;
    @ColumnInfo
    private String nextOpenTime;

    @Embedded
    private LocationEntity location;
    @Embedded
    private StoreStatusEntity storeStatus;

    @ColumnInfo
    private String url;

    @Embedded
    private ArrayList<MenuEntity> menuList;

    @ColumnInfo
    private String serviceRate;

    @ColumnInfo
    private long deliveryFee;
    @Embedded(prefix = "delivery_fee")
    private MonetaryMetadataEntity deliveryFeeMonetaryFields;

    @ColumnInfo
    private long extraSOSDeliveryFee;
    @Embedded(prefix = "sos_delivery_fee")
    private MonetaryMetadataEntity sosDeliveryFeeMonetaryFields;

    @ColumnInfo
    private boolean newlyAdded;
    @ColumnInfo
    private boolean consumerSubscriptionEligible;

    @ColumnInfo
    private double distanceFromConsumer;
    @Embedded
    private ArrayList<MerchantPromotionEntity> merchantPromotions;

    public StoreEntity() {

    }


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

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public StoreStatusEntity getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(StoreStatusEntity storeStatus) {
        this.storeStatus = storeStatus;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<MenuEntity> getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList<MenuEntity> menuList) {
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

    public MonetaryMetadataEntity getDeliveryFeeMonetaryFields() {
        return deliveryFeeMonetaryFields;
    }

    public void setDeliveryFeeMonetaryFields(MonetaryMetadataEntity deliveryFeeMonetaryFields) {
        this.deliveryFeeMonetaryFields = deliveryFeeMonetaryFields;
    }

    public long getExtraSOSDeliveryFee() {
        return extraSOSDeliveryFee;
    }

    public void setExtraSOSDeliveryFee(long extraSOSDeliveryFee) {
        this.extraSOSDeliveryFee = extraSOSDeliveryFee;
    }

    public MonetaryMetadataEntity getSosDeliveryFeeMonetaryFields() {
        return sosDeliveryFeeMonetaryFields;
    }

    public void setSosDeliveryFeeMonetaryFields(MonetaryMetadataEntity sosDeliveryFeeMonetaryFields) {
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

    public ArrayList<MerchantPromotionEntity> getMerchantPromotions() {
        return merchantPromotions;
    }

    public void setMerchantPromotions(ArrayList<MerchantPromotionEntity> merchantPromotions) {
        this.merchantPromotions = merchantPromotions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StoreEntity)) return false;
        StoreEntity that = (StoreEntity) o;
        return getId() == that.getId() &&
                getBusinessId() == that.getBusinessId() &&
                getNumRatings() == that.getNumRatings() &&
                Double.compare(that.getAverageRating(), getAverageRating()) == 0 &&
                getPriceRange() == that.getPriceRange() &&
                getDeliveryFee() == that.getDeliveryFee() &&
                getExtraSOSDeliveryFee() == that.getExtraSOSDeliveryFee() &&
                isNewlyAdded() == that.isNewlyAdded() &&
                isConsumerSubscriptionEligible() == that.isConsumerSubscriptionEligible() &&
                Double.compare(that.getDistanceFromConsumer(), getDistanceFromConsumer()) == 0 &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getCoverImageUrl(), that.getCoverImageUrl()) &&
                Objects.equals(getHeaderImageUrl(), that.getHeaderImageUrl()) &&
                Objects.equals(getNextCloseTime(), that.getNextCloseTime()) &&
                Objects.equals(getNextOpenTime(), that.getNextOpenTime()) &&
                Objects.equals(getLocation(), that.getLocation()) &&
                Objects.equals(getStoreStatus(), that.getStoreStatus()) &&
                Objects.equals(getUrl(), that.getUrl()) &&
                Objects.equals(getMenuList(), that.getMenuList()) &&
                Objects.equals(getServiceRate(), that.getServiceRate()) &&
                Objects.equals(getDeliveryFeeMonetaryFields(), that.getDeliveryFeeMonetaryFields()) &&
                Objects.equals(getSosDeliveryFeeMonetaryFields(), that.getSosDeliveryFeeMonetaryFields()) &&
                Objects.equals(getMerchantPromotions(), that.getMerchantPromotions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBusinessId(), getName(), getDescription(), getCoverImageUrl(), getHeaderImageUrl(), getNumRatings(), getAverageRating(), getPriceRange(), getNextCloseTime(), getNextOpenTime(), getLocation(), getStoreStatus(), getUrl(), getMenuList(), getServiceRate(), getDeliveryFee(), getDeliveryFeeMonetaryFields(), getExtraSOSDeliveryFee(), getSosDeliveryFeeMonetaryFields(), isNewlyAdded(), isConsumerSubscriptionEligible(), getDistanceFromConsumer(), getMerchantPromotions());
    }

    @Override
    public String toString() {
        return "StoreEntity{" +
                "id=" + id +
                ", businessId=" + businessId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                ", headerImageUrl='" + headerImageUrl + '\'' +
                ", numRatings=" + numRatings +
                ", averageRating=" + averageRating +
                ", priceRange=" + priceRange +
                ", nextCloseTime='" + nextCloseTime + '\'' +
                ", nextOpenTime='" + nextOpenTime + '\'' +
                ", location=" + location +
                ", storeStatus=" + storeStatus +
                ", url='" + url + '\'' +
                ", menuList=" + menuList +
                ", serviceRate='" + serviceRate + '\'' +
                ", deliveryFee=" + deliveryFee +
                ", deliveryFeeMonetaryFields=" + deliveryFeeMonetaryFields +
                ", extraSOSDeliveryFee=" + extraSOSDeliveryFee +
                ", sosDeliveryFeeMonetaryFields=" + sosDeliveryFeeMonetaryFields +
                ", newlyAdded=" + newlyAdded +
                ", consumerSubscriptionEligible=" + consumerSubscriptionEligible +
                ", distanceFromConsumer=" + distanceFromConsumer +
                ", merchantPromotions=" + merchantPromotions +
                '}';
    }
}