package com.androidnerds.doordash.data.remote.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class StoreFeedDTO implements Serializable {

    @SerializedName("num_results")
    private long numResult;
    @SerializedName("is_first_time_user")
    private boolean firstTimeUser;
    @SerializedName("sort_order")
    private String sortOrder;
    @SerializedName("next_offset")
    private long nextOffset;
    @SerializedName("show_list_as_pickup")
    private boolean showListAsPickup;
    @SerializedName("stores")
    private List<StoreDTO> stores;

    public long getNumResult() {
        return numResult;
    }

    public void setNumResult(long numResult) {
        this.numResult = numResult;
    }

    public boolean isFirstTimeUser() {
        return firstTimeUser;
    }

    public void setFirstTimeUser(boolean firstTimeUser) {
        this.firstTimeUser = firstTimeUser;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public long getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(long nextOffset) {
        this.nextOffset = nextOffset;
    }

    public boolean isShowListAsPickup() {
        return showListAsPickup;
    }

    public void setShowListAsPickup(boolean showListAsPickup) {
        this.showListAsPickup = showListAsPickup;
    }

    public List<StoreDTO> getStores() {
        return stores;
    }

    public void setStores(List<StoreDTO> stores) {
        this.stores = stores;
    }
}
