package com.androidnerds.doordash.domain.model;

public class StoreStatus {

    /**
     * val unavailableReason: String?,
     *  *     val pickupAvailable: Boolean,
     *  *     val asapAvailable: Boolean,
     *  *     val scheduledAvailable: Boolean,
     *  *     val asapMinuteRange: Array<Int>,
     */

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
}
