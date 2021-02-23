package com.androidnerds.doordash.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(tableName = "store_feed")
public class StoreFeedEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private long _id;
    @ColumnInfo
    private long numResult;
    @ColumnInfo
    private boolean firstTimeUser;
    @ColumnInfo
    private String sortOrder;
    @ColumnInfo
    private long nextOffset;
    @ColumnInfo
    private boolean showListAsPickup;
    @Embedded
    private ArrayList<StoreEntity> stores;



    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

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

    public ArrayList<StoreEntity> getStores() {
        return stores;
    }

    public void setStores(ArrayList<StoreEntity> stores) {
        this.stores = stores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StoreFeedEntity)) return false;
        StoreFeedEntity that = (StoreFeedEntity) o;
        return get_id() == that.get_id() &&
                getNumResult() == that.getNumResult() &&
                isFirstTimeUser() == that.isFirstTimeUser() &&
                getNextOffset() == that.getNextOffset() &&
                isShowListAsPickup() == that.isShowListAsPickup() &&
                Objects.equals(getSortOrder(), that.getSortOrder()) &&
                Objects.equals(getStores(), that.getStores());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), getNumResult(), isFirstTimeUser(), getSortOrder(), getNextOffset(), isShowListAsPickup(), getStores());
    }

    @Override
    public String toString() {
        return "StoreFeedEntity{" +
                "_id=" + _id +
                ", numResult=" + numResult +
                ", firstTimeUser=" + firstTimeUser +
                ", sortOrder='" + sortOrder + '\'' +
                ", nextOffset=" + nextOffset +
                ", showListAsPickup=" + showListAsPickup +
                ", stores=" + stores +
                '}';
    }
}
