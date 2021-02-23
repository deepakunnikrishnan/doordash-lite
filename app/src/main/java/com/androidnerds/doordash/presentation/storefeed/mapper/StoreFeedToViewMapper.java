package com.androidnerds.doordash.presentation.storefeed.mapper;

import com.androidnerds.doordash.domain.model.store.Store;
import com.androidnerds.doordash.domain.model.StoreFeed;
import com.androidnerds.doordash.core.mapper.ListMapper;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.presentation.storefeed.model.StoreFeedViewData;
import com.androidnerds.doordash.presentation.storefeed.model.StoreItemViewData;

public class StoreFeedToViewMapper implements Mapper<StoreFeed, StoreFeedViewData> {

    private ListMapper<Store, StoreItemViewData> mapper;

    public StoreFeedToViewMapper(ListMapper<Store, StoreItemViewData> mapper) {
        this.mapper = mapper;
    }

    @Override
    public StoreFeedViewData map(StoreFeed input) {
        StoreFeedViewData storeFeedViewData = new StoreFeedViewData();
        storeFeedViewData.setNumResult(input.getNumResult());
        storeFeedViewData.setFirstTimeUser(input.isFirstTimeUser());
        storeFeedViewData.setShowListAsPickup(input.isShowListAsPickup());
        storeFeedViewData.setStores(mapper.map(input.getStores()));
        return storeFeedViewData;
    }
}
