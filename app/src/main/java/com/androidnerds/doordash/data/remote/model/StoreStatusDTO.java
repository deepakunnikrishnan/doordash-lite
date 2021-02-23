package com.androidnerds.doordash.data.remote.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StoreStatusDTO implements Serializable {

    @SerializedName("unavailable_reason")
    private String unavailableReason;
    @SerializedName("pickup_available")
    private boolean pickupAvailable;
    @SerializedName("asap_available")
    private boolean asapAvailable;
    @SerializedName("scheduled_available")
    private boolean scheduledAvailable;
    @SerializedName("asap_minutes_range")
    private int[] asapMinuteRange;

    public String getUnavailableReason() {
        return unavailableReason;
    }

    public void setUnavailableReason(String unavailableReason) {
        this.unavailableReason = unavailableReason;
    }

    public boolean isPickupAvailable() {
        return pickupAvailable;
    }

    public void setPickupAvailable(boolean pickupAvailable) {
        this.pickupAvailable = pickupAvailable;
    }

    public boolean isAsapAvailable() {
        return asapAvailable;
    }

    public void setAsapAvailable(boolean asapAvailable) {
        this.asapAvailable = asapAvailable;
    }

    public boolean isScheduledAvailable() {
        return scheduledAvailable;
    }

    public void setScheduledAvailable(boolean scheduledAvailable) {
        this.scheduledAvailable = scheduledAvailable;
    }

    public int[] getAsapMinuteRange() {
        return asapMinuteRange;
    }

    public void setAsapMinuteRange(int[] asapMinuteRange) {
        this.asapMinuteRange = asapMinuteRange;
    }
}
