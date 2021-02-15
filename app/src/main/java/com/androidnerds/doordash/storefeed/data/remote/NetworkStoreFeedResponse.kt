package com.androidnerds.doordash.storefeed.data.remote

import com.google.gson.annotations.SerializedName

data class NetworkStoreFeedResponse(
    @SerializedName("num_results") val numResults: Long,
    @SerializedName("is_first_time_user") val isFirstTimeUser: Boolean,
    @SerializedName("sort_order") val sortOrder: String,
    @SerializedName("next_offset") val nextOffset: Long,
    @SerializedName("show_list_as_pickup") val showListAsPickup: Boolean,
    val stores: List<NetworkStore>)