package com.androidnerds.doordash.domain.model.store;

import com.androidnerds.doordash.domain.model.menu.MenuDetail;

public class StoreDetail {

    private Store store;
    private MenuDetail menuDetail;

    public StoreDetail(Store store, MenuDetail menuDetail) {
        this.store = store;
        this.menuDetail = menuDetail;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public MenuDetail getMenuDetail() {
        return menuDetail;
    }

    public void setMenuDetail(MenuDetail menuDetail) {
        this.menuDetail = menuDetail;
    }
}
