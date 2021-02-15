package com.androidnerds.doordash.storefeed.domain

data class StoreFeed(
    val numResult: Long,
    val isFirstTimeUser: Boolean,
    val sortOrder: String,
    val nextOffset: Long,
    val showListAsPickup: Boolean,
    val stores: List<Store>
)