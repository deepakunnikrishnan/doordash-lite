package com.androidnerds.doordash.domain.model;

public class MonetaryMetadata {

    private String currency;
    private String displayString;
    private long unitAmount;
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
