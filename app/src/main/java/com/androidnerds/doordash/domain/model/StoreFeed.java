package com.androidnerds.doordash.domain.model;

import com.androidnerds.doordash.domain.model.store.Store;

import java.util.List;

public class StoreFeed {

    private long numResult;
    private boolean firstTimeUser;
    private String sortOrder;
    private long nextOffset;
    private boolean showListAsPickup;
    private List<Store> stores;

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

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
}
