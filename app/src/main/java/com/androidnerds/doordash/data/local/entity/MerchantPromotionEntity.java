package com.androidnerds.doordash.data.local.entity;

import androidx.room.Entity;

import java.util.Objects;

@Entity(tableName = "merchant_promotions")
public class MerchantPromotionEntity {

    private long id;
    private boolean categoryNewStoreCustomersOnly;
    private MonetaryMetadataEntity minimumSubTotalMonetaryFields;
    private long deliveryFee;
    private MonetaryMetadataEntity deliveryFeeMonetaryFields;
    private long minimumSubTotal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isCategoryNewStoreCustomersOnly() {
        return categoryNewStoreCustomersOnly;
    }

    public void setCategoryNewStoreCustomersOnly(boolean categoryNewStoreCustomersOnly) {
        this.categoryNewStoreCustomersOnly = categoryNewStoreCustomersOnly;
    }

    public MonetaryMetadataEntity getMinimumSubTotalMonetaryFields() {
        return minimumSubTotalMonetaryFields;
    }

    public void setMinimumSubTotalMonetaryFields(MonetaryMetadataEntity minimumSubTotalMonetaryFields) {
        this.minimumSubTotalMonetaryFields = minimumSubTotalMonetaryFields;
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

    public long getMinimumSubTotal() {
        return minimumSubTotal;
    }

    public void setMinimumSubTotal(long minimumSubTotal) {
        this.minimumSubTotal = minimumSubTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MerchantPromotionEntity)) return false;
        MerchantPromotionEntity that = (MerchantPromotionEntity) o;
        return getId() == that.getId() &&
                isCategoryNewStoreCustomersOnly() == that.isCategoryNewStoreCustomersOnly() &&
                getDeliveryFee() == that.getDeliveryFee() &&
                getMinimumSubTotal() == that.getMinimumSubTotal() &&
                Objects.equals(getMinimumSubTotalMonetaryFields(), that.getMinimumSubTotalMonetaryFields()) &&
                Objects.equals(getDeliveryFeeMonetaryFields(), that.getDeliveryFeeMonetaryFields());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), isCategoryNewStoreCustomersOnly(), getMinimumSubTotalMonetaryFields(), getDeliveryFee(), getDeliveryFeeMonetaryFields(), getMinimumSubTotal());
    }

    @Override
    public String toString() {
        return "MerchantPromotionEntity{" +
                "id=" + id +
                ", categoryNewStoreCustomersOnly=" + categoryNewStoreCustomersOnly +
                ", minimumSubTotalMonetaryFields=" + minimumSubTotalMonetaryFields +
                ", deliveryFee=" + deliveryFee +
                ", deliveryFeeMonetaryFields=" + deliveryFeeMonetaryFields +
                ", minimumSubTotal=" + minimumSubTotal +
                '}';
    }
}
