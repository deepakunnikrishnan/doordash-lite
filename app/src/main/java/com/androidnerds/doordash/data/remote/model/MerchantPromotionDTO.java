package com.androidnerds.doordash.data.remote.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MerchantPromotionDTO implements Serializable {

    @SerializedName("id")
    private long id;
    @SerializedName("category_new_store_customers_only")
    private boolean categoryNewStoreCustomersOnly;
    @SerializedName("minimum_subtotal_monetary_fields")
    private MonetaryMetadataDTO minimumSubTotalMonetaryFields;
    @SerializedName("delivery_fee")
    private long deliveryFee;
    @SerializedName("delivery_fee_monetary_fields")
    private MonetaryMetadataDTO deliveryFeeMonetaryFields;
    @SerializedName("minimum_subtotal")
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

    public MonetaryMetadataDTO getMinimumSubTotalMonetaryFields() {
        return minimumSubTotalMonetaryFields;
    }

    public void setMinimumSubTotalMonetaryFields(MonetaryMetadataDTO minimumSubTotalMonetaryFields) {
        this.minimumSubTotalMonetaryFields = minimumSubTotalMonetaryFields;
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

    public long getMinimumSubTotal() {
        return minimumSubTotal;
    }

    public void setMinimumSubTotal(long minimumSubTotal) {
        this.minimumSubTotal = minimumSubTotal;
    }
}
