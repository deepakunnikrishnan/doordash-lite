package com.androidnerds.doordash.storefeed.data.remote

import com.google.gson.annotations.SerializedName

data class NetworkStore(
    @SerializedName("id") val id: Long,
    @SerializedName("business_id") val businessId: Long,
    val name: String,
    val description: String,
    @SerializedName("cover_img_url")val coverImageUrl: String,
    @SerializedName("header_img_url")val headerImageUrl: String,
    @SerializedName("num_ratings") val numRatings: Long,
    @SerializedName("average_rating") val averageRating: Double,
    @SerializedName("price_range") val priceRange: Int,
    @SerializedName("next_close_time") val nextCloseTime: String,
    @SerializedName("next_open_time")val nextOpenTime: String,
    val location: Location,
    val status: StoreStatus,
    val url: String,
    val menus: List<Menu>,
    @SerializedName("service_rate")val serviceRate: String?,
    @SerializedName("delivery_fee") val deliveryFee: Long = 0,
    @SerializedName("display_delivery_fee") val displayDeliveryFee: String,
    @SerializedName("delivery_fee_monetary_fields") val deliveryFeeMonetaryFields: MonetaryMetadata,
    @SerializedName("extra_sos_delivery_fee") val extraSOSDeliveryFee: Long,
    @SerializedName("extra_sos_delivery_fee_monetary_fields") val sosDeliveryFeeMonetaryFields: MonetaryMetadata,
    @SerializedName("is_newly_added") val isNewlyAdded: Boolean,
    @SerializedName("is_consumer_subscription_eligible") val isConsumerSubscriptionEligible: Boolean,
    @SerializedName("distance_from_consumer") val distanceFromConsumer: Double,
    @SerializedName("merchant_promotions") val merchantPromotions: List<MerchantPromotion>,
    )


data class MonetaryMetadata(
    val currency: String,
    @SerializedName("display_string") val displayString: String,
    @SerializedName("unit_amount") val unitAmount: Long = 0,
    @SerializedName("decimal_places") val decimalPlaces: Int,

)

data class Menu(
    val id: Long,
    val name: String,
    val subTitle: String,
    val isCatering: Boolean,
    @SerializedName("popular_items") val popularItems: List<FoodItem>
)

data class FoodItem(
    val id: Long,
    val name: String,
    val description: String,
    @SerializedName("img_url") val imageUrl: String,
    val price: Long
)

data class Location(
    @SerializedName("lat") val latitude: Double,
    @SerializedName("lng") val longitude: Double,
)

data class StoreStatus(
    @SerializedName("unavailable_reason") val unavailableReason: String?,
    @SerializedName("pickup_available") val pickupAvailable: Boolean,
    @SerializedName("asap_available") val asapAvailable: Boolean,
    @SerializedName("scheduled_available") val scheduledAvailable: Boolean,
    @SerializedName("asap_minutes_range") val asapMinuteRange: Array<Int>,
)

data class MerchantPromotion(
    val id: Long,
    @SerializedName("category_new_store_customers_only") val categoryNewStoreCustomersOnly: Boolean,
    @SerializedName("minimum_subtotal_monetary_fields") val minimumSubTotalMonetaryFields: MonetaryMetadata,
    @SerializedName("delivery_fee") val deliveryFee: Long = 0,
    @SerializedName("delivery_fee_monetary_fields") val deliveryFeeMonetaryFields: MonetaryMetadata,
    @SerializedName("minimum_subtotal") val minimumSubTotal: Long = 0,
)