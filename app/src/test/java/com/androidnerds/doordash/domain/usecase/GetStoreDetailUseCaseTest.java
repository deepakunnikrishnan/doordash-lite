package com.androidnerds.doordash.domain.usecase;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.core.rx.SchedulerProvider;
import com.androidnerds.doordash.core.utils.Result;
import com.androidnerds.doordash.domain.IStoreRepository;
import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.domain.model.StoreFeed;
import com.androidnerds.doordash.domain.model.menu.MenuDetail;
import com.androidnerds.doordash.domain.model.store.Store;
import com.androidnerds.doordash.domain.model.store.StoreDetail;
import com.androidnerds.doordash.presentation.restaurant.detail.model.StoreDetailViewData;
import com.androidnerds.doordash.presentation.storefeed.model.StoreFeedViewData;
import com.androidnerds.doordash.rx.DefaultScheduler;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class GetStoreDetailUseCaseTest {

    @Mock
    private IStoreRepository storeRepository;
    @Mock
    private Mapper<StoreDetail, StoreDetailViewData> mapper;
    private SchedulerProvider schedulerProvider;

    @Mock
    private Observer<Result<StoreDetailViewData, Throwable>> observer;

    @Captor
    private ArgumentCaptor<Result<StoreDetailViewData,Throwable>> argumentCaptor;

    @Rule
    public final InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        schedulerProvider = new DefaultScheduler();
    }

    @Test
    public void testExecuteSuccess() {
        GetStoreDetailUseCase storeDetailUseCase = new GetStoreDetailUseCase(storeRepository, mapper, schedulerProvider);

        MockResponseFileReader mockResponseFileReader = new MockResponseFileReader(ApiConstants.MENU_DETAIL_DOMAIN);
        String content = mockResponseFileReader.getContent();
        MenuDetail menuDetail = new Gson().fromJson(content, MenuDetail.class);
        assertNotNull(menuDetail);

        StoreDetailViewData storeDetailViewData = new StoreDetailViewData();
        Mockito.when(mapper.map(Mockito.any(StoreDetail.class))).thenReturn(storeDetailViewData);
        Mockito.when(storeRepository.getStore(10)).thenReturn(Single.just(new Store()));
        Mockito.when(storeRepository.getMenuDetails(10)).thenReturn(Single.just(new MenuDetail()));

        //operation
        storeDetailUseCase.getLiveData().observeForever(observer);
        storeDetailUseCase.execute(10);

        //verify
        Mockito.verify(observer).onChanged(argumentCaptor.capture());
        Assert.assertNotNull(argumentCaptor.getValue().getData());
        Assert.assertNull(argumentCaptor.getValue().getError());
    }

    @Test
    public void testExecuteFailure() {
        GetStoreDetailUseCase storeDetailUseCase = new GetStoreDetailUseCase(storeRepository, mapper, schedulerProvider);

        MockResponseFileReader mockResponseFileReader = new MockResponseFileReader(ApiConstants.MENU_DETAIL_DOMAIN);
        String content = mockResponseFileReader.getContent();
        MenuDetail menuDetail = new Gson().fromJson(content, MenuDetail.class);
        assertNotNull(menuDetail);

        Mockito.when(storeRepository.getStore(10)).thenReturn(Single.just(new Store()));
        Mockito.when(storeRepository.getMenuDetails(10)).thenReturn(Single.error(new Exception()));

        //operation
        storeDetailUseCase.getLiveData().observeForever(observer);
        storeDetailUseCase.execute(10);

        //verify
        Mockito.verify(observer).onChanged(argumentCaptor.capture());
        Assert.assertNull(argumentCaptor.getValue().getData());
        Assert.assertNotNull(argumentCaptor.getValue().getError());
    }
}