package com.androidnerds.doordash.domain.model;

public class MerchantPromotion {

    private long id;
    private boolean categoryNewStoreCustomersOnly;
    private MonetaryMetadata minimumSubTotalMonetaryFields;
    private long deliveryFee;
    private MonetaryMetadata deliveryFeeMonetaryFields;
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

    public MonetaryMetadata getMinimumSubTotalMonetaryFields() {
        return minimumSubTotalMonetaryFields;
    }

    public void setMinimumSubTotalMonetaryFields(MonetaryMetadata minimumSubTotalMonetaryFields) {
        this.minimumSubTotalMonetaryFields = minimumSubTotalMonetaryFields;
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

    public long getMinimumSubTotal() {
        return minimumSubTotal;
    }

    public void setMinimumSubTotal(long minimumSubTotal) {
        this.minimumSubTotal = minimumSubTotal;
    }
}
