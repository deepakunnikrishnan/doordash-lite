package com.androidnerds.doordash.storefeed.presentation.model


data class StoreFeedView(
    val id: Long,
    val storeView: List<StoreView>
    )

data class StoreView(val id: Long)