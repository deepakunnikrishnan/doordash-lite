package com.androidnerds.doordash.domain.mapper.store;

import com.androidnerds.doordash.data.remote.model.StoreDTO;
import com.androidnerds.doordash.data.remote.model.StoreFeedDTO;
import com.androidnerds.doordash.domain.model.store.Store;
import com.androidnerds.doordash.domain.model.StoreFeed;
import com.androidnerds.doordash.core.mapper.ListMapper;
import com.androidnerds.doordash.core.mapper.Mapper;

import javax.inject.Inject;

public class StoreFeedDTOToStoreFeedMapper implements Mapper<StoreFeedDTO, StoreFeed> {

    private final ListMapper<StoreDTO, Store> storeListMapper;

    @Inject
    public StoreFeedDTOToStoreFeedMapper(ListMapper<StoreDTO, Store> storeListMapper) {
        this.storeListMapper = storeListMapper;
    }

    @Override
    public StoreFeed map(StoreFeedDTO input) {
        StoreFeed storeFeed = new StoreFeed();
        storeFeed.setFirstTimeUser(input.isFirstTimeUser());
        storeFeed.setNextOffset(input.getNextOffset());
        storeFeed.setNumResult(input.getNumResult());
        storeFeed.setShowListAsPickup(input.isShowListAsPickup());
        storeFeed.setStores(storeListMapper.map(input.getStores()));
        return storeFeed;
    }
}

/**
 *
 * class StoreDataMapper(
 *     private val locationDataMapper: LocationDataMapper,
 *     private val statusDataMapper: StoreStatusDataMapper,
 *     private val menusListMapper: NullableInputListMapper<com.androidnerds.doordash.storefeed.data.remote.Menu, Menu>,
 *     private val monetaryMetadataDataMapper: MonetaryMetadataDataMapper,
 *     private val merchantPromotionListMapper: NullableInputListMapper<MerchantPromotion, com.androidnerds.doordash.storefeed.domain.MerchantPromotion>
 * ) : Mapper<NetworkStore, Store> {
 *     override fun map(input: NetworkStore): Store {
 *         return Store(
 *             id = input.id.or(0),
 *             businessId = input.businessId.or(0),
 *             name = input.name, description = input.description,
 *             coverImageUrl = input.coverImageUrl, headerImageUrl = input.headerImageUrl,
 *             numRatings = input.numRatings, averageRating = input.averageRating,
 *             priceRange = input.priceRange,
 *             nextCloseTime = input.nextCloseTime,
 *             nextOpenTime = input.nextOpenTime,
 *             location = locationDataMapper.map(input.location),
 *             status = statusDataMapper.map(input.status),
 *             url = input.url,
 *             menus = menusListMapper.map(input.menus),
 *             serviceRate = input.serviceRate,
 *             deliveryFee = input.deliveryFee,
 *             displayDeliveryFee = input.displayDeliveryFee,
 *             deliveryFeeMonetaryFields = monetaryMetadataDataMapper.map(input.deliveryFeeMonetaryFields),
 *             extraSOSDeliveryFee = input.extraSOSDeliveryFee,
 *             sosDeliveryFeeMonetaryFields = monetaryMetadataDataMapper.map(input.sosDeliveryFeeMonetaryFields),
 *             isNewlyAdded = input.isNewlyAdded,
 *             isConsumerSubscriptionEligible = input.isConsumerSubscriptionEligible,
 *             distanceFromConsumer = input.distanceFromConsumer,
 *             merchantPromotions = merchantPromotionListMapper.map(input.merchantPromotions)
 *         )
 *     }
 * }
 *
 * class LocationDataMapper :
 *     Mapper<com.androidnerds.doordash.storefeed.data.remote.Location, Location> {
 *     override fun map(input: com.androidnerds.doordash.storefeed.data.remote.Location): Location {
 *         return Location(input.latitude, input.longitude)
 *     }
 * }
 *
 * class StoreStatusDataMapper :
 *     Mapper<StoreStatus, com.androidnerds.doordash.storefeed.domain.StoreStatus> {
 *     override fun map(input: StoreStatus): com.androidnerds.doordash.storefeed.domain.StoreStatus {
 *         return com.androidnerds.doordash.storefeed.domain.StoreStatus(
 *             input.unavailableReason,
 *             input.pickupAvailable,
 *             input.asapAvailable,
 *             input.scheduledAvailable,
 *             input.asapMinuteRange
 *         )
 *     }
 * }
 *
 * class MenuDataMapper(
 *     private val foodItemListDataDataMapper:
 *     NullableInputListMapper<FoodItem, com.androidnerds.doordash.storefeed.domain.FoodItem>
 * ) : Mapper<com.androidnerds.doordash.storefeed.data.remote.Menu, Menu> {
 *     override fun map(input: com.androidnerds.doordash.storefeed.data.remote.Menu): Menu {
 *         return Menu(
 *             input.id,
 *             input.name,
 *             input.subTitle,
 *             input.isCatering,
 *             foodItemListDataDataMapper.map(input.popularItems)
 *         )
 *     }
 * }
 *
 * class FoodItemDataMapper : Mapper<FoodItem, com.androidnerds.doordash.storefeed.domain.FoodItem> {
 *     override fun map(input: FoodItem): com.androidnerds.doordash.storefeed.domain.FoodItem {
 *         return com.androidnerds.doordash.storefeed.domain.FoodItem(
 *             input.id,
 *             input.name,
 *             input.description,
 *             price = input.price,
 *             imageUrl = input.imageUrl
 *         )
 *     }
 *
 * }
 *
 * class MonetaryMetadataDataMapper :
 *     Mapper<MonetaryMetadata, com.androidnerds.doordash.storefeed.domain.MonetaryMetadata> {
 *     override fun map(input: MonetaryMetadata): com.androidnerds.doordash.storefeed.domain.MonetaryMetadata {
 *         return com.androidnerds.doordash.storefeed.domain.MonetaryMetadata(
 *             input.currency,
 *             input.displayString,
 *             input.unitAmount,
 *             input.decimalPlaces
 *         )
 *     }
 * }
 *
 * class MerchantPromotionDataMapper(private val monetaryMetadataDataMapper: MonetaryMetadataDataMapper) :
 *     Mapper<MerchantPromotion, com.androidnerds.doordash.storefeed.domain.MerchantPromotion> {
 *     override fun map(input: MerchantPromotion): com.androidnerds.doordash.storefeed.domain.MerchantPromotion {
 *         return com.androidnerds.doordash.storefeed.domain.MerchantPromotion(
 *             input.id,
 *             input.categoryNewStoreCustomersOnly,
 *             monetaryMetadataDataMapper.map(input.minimumSubTotalMonetaryFields),
 *             input.deliveryFee,
 *             monetaryMetadataDataMapper.map(input.deliveryFeeMonetaryFields),
 *             input.minimumSubTotal
 *         )
 *     }
 * }
 *
 */
