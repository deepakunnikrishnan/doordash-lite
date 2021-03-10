package com.androidnerds.doordash.di;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.androidnerds.doordash.core.rx.SchedulerProvider;
import com.androidnerds.doordash.data.remote.constant.RemoteConstants;
import com.androidnerds.doordash.di.data.DataModule;
import com.androidnerds.doordash.di.data.LocalModule;
import com.androidnerds.doordash.di.data.MapperModule;
import com.androidnerds.doordash.di.data.RemoteModule;
import com.androidnerds.doordash.domain.model.category.Category;
import com.androidnerds.doordash.domain.model.category.CategoryItem;
import com.androidnerds.doordash.domain.model.store.Store;
import com.androidnerds.doordash.domain.model.StoreFeed;
import com.androidnerds.doordash.core.mapper.ListMapper;
import com.androidnerds.doordash.core.mapper.ListMapperImpl;
import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.domain.model.store.StoreDetail;
import com.androidnerds.doordash.domain.usecase.GetStoreDetailUseCase;
import com.androidnerds.doordash.domain.usecase.GetStoreFeedUseCase;
import com.androidnerds.doordash.presentation.restaurant.detail.mapper.CategoryItemToViewMapper;
import com.androidnerds.doordash.presentation.restaurant.detail.mapper.CategoryToViewMapper;
import com.androidnerds.doordash.presentation.restaurant.detail.mapper.StoreDetailToViewMapper;
import com.androidnerds.doordash.presentation.restaurant.detail.model.CategoryItemViewData;
import com.androidnerds.doordash.presentation.restaurant.detail.model.CategoryViewData;
import com.androidnerds.doordash.presentation.restaurant.detail.model.StoreDetailViewData;
import com.androidnerds.doordash.presentation.restaurant.detail.viemodel.RestaurantDetailViewModelFactory;
import com.androidnerds.doordash.presentation.storefeed.mapper.StoreFeedToViewMapper;
import com.androidnerds.doordash.presentation.storefeed.mapper.StoreItemViewMapper;
import com.androidnerds.doordash.presentation.storefeed.model.StoreFeedViewData;
import com.androidnerds.doordash.presentation.storefeed.model.StoreItemViewData;
import com.androidnerds.doordash.presentation.storefeed.viewmodel.StoreFeedViewModel;
import com.androidnerds.doordash.presentation.storefeed.viewmodel.StoreFeedViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {ViewModelModule.class})
public abstract class PresentationModule {


    /*@Provides
    public static StoreFeedViewModelFactory provideStoreFeedViewModelFactory(GetStoreFeedUseCase storeFeedUseCase,
                                                                             SchedulerProvider schedulerProvider) {
        return new StoreFeedViewModelFactory(storeFeedUseCase, schedulerProvider);
    }*/

    @Binds
    public abstract Mapper<StoreFeed, StoreFeedViewData> provideStoreFeedMapper(StoreFeedToViewMapper mapper);

    @Provides
    public static ListMapper<Store, StoreItemViewData> provideStoreItemListMapper(Mapper<Store, StoreItemViewData> mapper) {
        return new ListMapperImpl<>(mapper);
    }
    @Binds
    public abstract Mapper<Store, StoreItemViewData> provideStoreItemMapper(StoreItemViewMapper mapper);

    /*@Provides
    public static RestaurantDetailViewModelFactory provideRestaurantDetailViewModelFactory(long id, GetStoreDetailUseCase getStoreDetailUseCase, SchedulerProvider schedulerProvider) {
        return new RestaurantDetailViewModelFactory(id, getStoreDetailUseCase, schedulerProvider);
    }*/

    @Binds
    public abstract Mapper<StoreDetail, StoreDetailViewData> provideStoreDetailMapper(StoreDetailToViewMapper mapper);

    @Provides
    public static ListMapper<Category, CategoryViewData> provideCategoryListMapper(Mapper<Category, CategoryViewData> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    @Binds
    public abstract Mapper<Category, CategoryViewData> provideCategoryMapper(CategoryToViewMapper mapper);

    @Provides
    public static ListMapper<CategoryItem, CategoryItemViewData> provideCategoryItemListMapper(Mapper<CategoryItem, CategoryItemViewData> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    @Binds
    public abstract Mapper<CategoryItem, CategoryItemViewData> provideCategoryItemMapper(CategoryItemToViewMapper mapper);

    /*public static StoreFeedViewModelFactory provideStoreFeedViewModelFactory(Context context) {
        return new StoreFeedViewModelFactory(
                UseCaseModule.provideGetStoreFeedUseCase(
                        DataModule.provideStoreFeedRepository(
                                DataModule.provideStoreFeedRemoteDataSource(
                                        RemoteModule.provideStoreFeedService(
                                                RemoteModule.provideRetrofit(null,
                                                        RemoteModule.provideOkHttpClient(
                                                                new HttpLoggingInterceptor()
                                                        ),
                                                        GsonConverterFactory.create(),
                                                        RxJava3CallAdapterFactory.create()
                                                )
                                        ),
                                        SchedulerModule.provideSchedulerProvider()
                                ),
                                DataModule.provideStoreFeedLocalDataSource(
                                        LocalModule.provideStoreFeedDao(
                                                LocalModule.provideAppDatabase(context)
                                        ),
                                        LocalModule.provideStoreDao(
                                                LocalModule.provideAppDatabase(context)
                                        ),
                                        SchedulerModule.provideSchedulerProvider()
                                ),
                                DataModule.provideStoreLocalDataSource(
                                        LocalModule.provideStoreDao(
                                                LocalModule.provideAppDatabase(context)
                                        )
                                ),
                                MapperModule.provideStoreFeedDTOtoStoreFeedMapper(
                                        MapperModule.provideStoreDTOListToStoreListMapper(
                                                MapperModule.provideStoreDTOToStoreMapper(
                                                        MapperModule.provideLocationDTOtoDomainMapper(),
                                                        MapperModule.provideStoreStatusDTOtoDomainMapper(),
                                                        MapperModule.provideMenuDTOListToDomainMapper(
                                                                MapperModule.provideMenuDTOToDomainMapper(
                                                                        MapperModule.provideFoodItemDTOListToDomainMapper(
                                                                                MapperModule.provideFoodItemDTOToDomainMapper()
                                                                        )
                                                                )
                                                        ),
                                                        MapperModule.provideMonetaryMetadataDTOtoDomainMapper(),
                                                        MapperModule.provideMerchantPromotionDTOListToDomainMapper(
                                                                MapperModule.provideMerchantPromotionDTOToDomainMapper(
                                                                        MapperModule.provideMonetaryMetadataDTOtoDomainMapper()
                                                                )
                                                        )

                                                )
                                        )
                                ),
                                MapperModule.provideStoreDTOListToStoreEntityListMapper(
                                        MapperModule.provideStoreDTOToStoreEntityMapper(
                                                MapperModule.provideLocationDTOtoEntityMapper(),
                                                MapperModule.provideStoreStatusDTOtoEntityMapper(),
                                                MapperModule.provideMenuDTOListToEntityMapper(
                                                        MapperModule.provideMenuDTOToEntityMapper(
                                                                MapperModule.provideFoodItemDTOListToEntityMapper(
                                                                        MapperModule.provideFoodItemDTOToEntityMapper()
                                                                )
                                                        )
                                                ),
                                                MapperModule.provideMonetaryMetadataDTOtoEntityMapper(),
                                                MapperModule.provideMerchantPromotionDTOListToEntityMapper(
                                                        MapperModule.provideMerchantPromotionDTOToEntityMapper(
                                                                MapperModule.provideMonetaryMetadataDTOtoEntityMapper()
                                                        )
                                                )
                                        )
                                ),
                                SchedulerModule.provideSchedulerProvider()
                        ),
                        provideStoreFeedMapper(
                                provideStoreItemListMapper(
                                        provideStoreItemMapper(context)
                                )
                        ),
                        SchedulerModule.provideSchedulerProvider()
                ),
                SchedulerModule.provideSchedulerProvider()
                );
    }

    public static Mapper<StoreFeed, StoreFeedViewData> provideStoreFeedMapper(ListMapper<Store, StoreItemViewData> listMapper) {
        return new StoreFeedToViewMapper(listMapper);
    }

    public static ListMapper<Store, StoreItemViewData> provideStoreItemListMapper(Mapper<Store, StoreItemViewData> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    public static Mapper<Store, StoreItemViewData> provideStoreItemMapper(Context context) {
        return new StoreItemViewMapper(context);
    }

    public static RestaurantDetailViewModelFactory provideRestaurantDetailViewModelFactory(Context context, long id) {
        return new RestaurantDetailViewModelFactory(id,
                UseCaseModule.provideGetStoreDetailUseCase(
                        DataModule.provideStoreRepository(
                                DataModule.provideStoreRemoteDataSource(
                                        RemoteModule.provideStoreDetailService(
                                                RemoteModule.provideRetrofit(null,
                                                        RemoteModule.provideOkHttpClient(
                                                                new HttpLoggingInterceptor()
                                                        ),
                                                        GsonConverterFactory.create(),
                                                        RxJava3CallAdapterFactory.create()
                                                )
                                        ),
                                        SchedulerModule.provideSchedulerProvider()

                                ),
                                DataModule.provideStoreLocalDataSource(
                                        LocalModule.provideStoreDao(
                                                LocalModule.provideAppDatabase(
                                                        context
                                                )
                                        )
                                ),
                                MapperModule.provideStoreEntityToStoreMapper(
                                        MapperModule.provideLocationEntitytoDomainMapper(),
                                        MapperModule.provideStoreStatusEntitytoDomainMapper(),
                                        MapperModule.provideMenuEntityListToDomainMapper(
                                                MapperModule.provideMenuEntityToDomainMapper(
                                                        MapperModule.provideFoodItemEntityListToDomainMapper(
                                                                MapperModule.provideFoodItemEntityToDomainMapper()
                                                        )
                                                )
                                        ),
                                        MapperModule.provideMonetaryMetadataEntityToDomainMapper(),
                                        MapperModule.provideMerchantPromotionEntityListToDomainMapper(
                                                MapperModule.provideMerchantPromotionEntityToDomainMapper(
                                                        MapperModule.provideMonetaryMetadataEntityToDomainMapper()
                                                )
                                        )
                                ),
                                MapperModule.provideMenuDetailDTOtoDomainMapper(
                                        MapperModule.provideCategoryDTOListToDomainMapper(
                                                MapperModule.provideCategoryDTOtoDomainMapper(
                                                        MapperModule.provideCategoryItemDTOListToDomainMapper(
                                                                MapperModule.provideCategoryItemDTOtoDomainMapper(
                                                                        MapperModule.provideMonetaryMetadataDTOtoDomainMapper()
                                                                )
                                                        )
                                                )
                                        )
                                )
                        ),
                        provideStoreDetailMapper(context,
                                provideCategoryListMapper(
                                        provideCategoryMapper(
                                                provideCategoryItemListMapper(
                                                        provideCategoryItemMapper()
                                                )
                                        )
                                )
                        ),
                        SchedulerModule.provideSchedulerProvider()
                ),
                SchedulerModule.provideSchedulerProvider()
        );
    }

    public static Mapper<StoreDetail, StoreDetailViewData> provideStoreDetailMapper(Context context, ListMapper<Category, CategoryViewData> categoryItemViewDataListMapper) {
        return new StoreDetailToViewMapper(
                context,
                categoryItemViewDataListMapper);
    }

    public static ListMapper<Category, CategoryViewData> provideCategoryListMapper(Mapper<Category, CategoryViewData> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    public static Mapper<Category, CategoryViewData> provideCategoryMapper(ListMapper<CategoryItem, CategoryItemViewData> mapper) {
        return new CategoryToViewMapper(mapper);
    }

    public static ListMapper<CategoryItem, CategoryItemViewData> provideCategoryItemListMapper(Mapper<CategoryItem, CategoryItemViewData> mapper) {
        return new ListMapperImpl<>(mapper);
    }

    public static Mapper<CategoryItem, CategoryItemViewData> provideCategoryItemMapper() {
        return new CategoryItemToViewMapper();
    }*/


}
