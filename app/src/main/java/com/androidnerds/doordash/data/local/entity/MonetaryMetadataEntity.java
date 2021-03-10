package com.androidnerds.doordash.data.local.entity;

import java.util.Objects;

public class MonetaryMetadataEntity {


    private long _id;

    private String currency;
    private String displayString;
    private long unitAmount;
    private int decimalPlaces;

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MonetaryMetadataEntity)) return false;
        MonetaryMetadataEntity that = (MonetaryMetadataEntity) o;
        return get_id() == that.get_id() &&
                getUnitAmount() == that.getUnitAmount() &&
                getDecimalPlaces() == that.getDecimalPlaces() &&
                Objects.equals(getCurrency(), that.getCurrency()) &&
                Objects.equals(getDisplayString(), that.getDisplayString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), getCurrency(), getDisplayString(), getUnitAmount(), getDecimalPlaces());
    }

    @Override
    public String toString() {
        return "MonetaryMetadataEntity{" +
                "_id=" + _id +
                ", currency='" + currency + '\'' +
                ", displayString='" + displayString + '\'' +
                ", unitAmount=" + unitAmount +
                ", decimalPlaces=" + decimalPlaces +
                '}';
    }
}
