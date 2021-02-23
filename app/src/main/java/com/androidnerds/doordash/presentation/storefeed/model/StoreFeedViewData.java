package com.androidnerds.doordash.presentation.storefeed.model;

import java.util.List;

public class StoreFeedViewData {

    private long numResult;
    private boolean firstTimeUser;
    private String sortOrder;
    private long nextOffset;
    private boolean showListAsPickup;
    private List<StoreItemViewData> stores;

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

    public List<StoreItemViewData> getStores() {
        return stores;
    }

    public void setStores(List<StoreItemViewData> stores) {
        this.stores = stores;
    }
}


