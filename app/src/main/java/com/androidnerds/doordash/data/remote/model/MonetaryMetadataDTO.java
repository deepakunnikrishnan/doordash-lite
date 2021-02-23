package com.androidnerds.doordash.data.remote.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MonetaryMetadataDTO implements Serializable {

    @SerializedName("currency")
    private String currency;
    @SerializedName("display_string")
    private String displayString;
    @SerializedName("unit_amount")
    private long unitAmount;
    @SerializedName("decimal_places")
    private int decimalPlaces;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDisplayString() {
        return displayString;
    }

    public void setDisplayString(String displayString) {
        this.displayString = displayString;
    }

    public long getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(long unitAmount) {
        this.unitAmount = unitAmount;
    }

    public int getDecimalPlaces() {
        return decimalPlaces;
    }

    public void setDecimalPlaces(int decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }
}
