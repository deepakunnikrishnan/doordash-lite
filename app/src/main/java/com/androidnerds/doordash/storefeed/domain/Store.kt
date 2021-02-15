package com.androidnerds.doordash.storefeed.domain

data class Store(
    val id: Long,
    val businessId: Long,
    val name: String,
    val description: String,
    val coverImageUrl: String,
    val headerImageUrl: String,
    val numRatings: Long,
    val averageRating: Double,
    val priceRange: Int,
    val nextCloseTime: String,
    val nextOpenTime: String,
    val location: Location,
    val status: StoreStatus,
    val url: String,
    val menus: List<Menu>,
    val serviceRate: String?,
    val deliveryFee: Long = 0,
    val displayDeliveryFee: String,
    val deliveryFeeMonetaryFields: MonetaryMetadata,
    val extraSOSDeliveryFee: Long,
    val sosDeliveryFeeMonetaryFields: MonetaryMetadata,
    val isNewlyAdded: Boolean,
    val isConsumerSubscriptionEligible: Boolean,
    val distanceFromConsumer: Double,
    val merchantPromotions: List<MerchantPromotion>,
    )


data class MonetaryMetadata(
    val currency: String,
    val displayString: String,
    val unitAmount: Long = 0,
    val decimalPlaces: Int,

)

data class Menu(
    val id: Long,
    val name: String,
    val subTitle: String,
    val isCatering: Boolean,
    val popularItems: List<FoodItem>
)

data class FoodItem(
    val id: Long,
    val name: String,
    val description: String,
    val imageUrl: String,
    val price: Long
)

data class Location(
    val latitude: Double,
    val longitude: Double,
)

data class StoreStatus(
    val unavailableReason: String?,
    val pickupAvailable: Boolean,
    val asapAvailable: Boolean,
    val scheduledAvailable: Boolean,
    val asapMinuteRange: Array<Int>,
)

data class MerchantPromotion(
    val id: Long,
    val categoryNewStoreCustomersOnly: Boolean,
    val minimumSubTotalMonetaryFields: MonetaryMetadata,
    val deliveryFee: Long = 0,
    val deliveryFeeMonetaryFields: MonetaryMetadata,
    val minimumSubTotal: Long = 0,
)
