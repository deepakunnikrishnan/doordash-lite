package com.androidnerds.doordash.data.local.entity;

import java.util.Arrays;
import java.util.Objects;

public class StoreStatusEntity {

    private String unavailableReason;
    private boolean pickupAvailable;
    private boolean asapAvailable;
    private boolean scheduledAvailable;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StoreStatusEntity)) return false;
        StoreStatusEntity that = (StoreStatusEntity) o;
        return isPickupAvailable() == that.isPickupAvailable() &&
                isAsapAvailable() == that.isAsapAvailable() &&
                isScheduledAvailable() == that.isScheduledAvailable() &&
                Objects.equals(getUnavailableReason(), that.getUnavailableReason()) &&
                Arrays.equals(getAsapMinuteRange(), that.getAsapMinuteRange());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getUnavailableReason(), isPickupAvailable(), isAsapAvailable(), isScheduledAvailable());
        result = 31 * result + Arrays.hashCode(getAsapMinuteRange());
        return result;
    }

    @Override
    public String toString() {
        return "StoreStatusEntity{" +
                "unavailableReason='" + unavailableReason + '\'' +
                ", pickupAvailable=" + pickupAvailable +
                ", asapAvailable=" + asapAvailable +
                ", scheduledAvailable=" + scheduledAvailable +
                ", asapMinuteRange=" + Arrays.toString(asapMinuteRange) +
                '}';
    }
}
