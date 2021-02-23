package com.androidnerds.doordash.domain.usecase;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.core.rx.SchedulerProvider;
import com.androidnerds.doordash.core.utils.Result;
import com.androidnerds.doordash.domain.IStoreFeedRepository;
import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.domain.model.StoreFeed;
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

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class GetStoreFeedUseCaseTest {

    private double DEFAULT_LATITUDE = 37.422740;
    private double DEFAULT_LONGITUDE = -122.139956;
    private static final int LIMIT = 50;
    private long offset = 0;

    @Mock
    private IStoreFeedRepository storeFeedRepository;
    private SchedulerProvider schedulerProvider;
    @Mock
    private Mapper<StoreFeed, StoreFeedViewData> mapper;
    @Mock
    private Observer<Result<StoreFeedViewData, Throwable>> observer;

    @Captor
    private ArgumentCaptor<Result<StoreFeedViewData,Throwable>> argumentCaptor;

    @Rule
    public final InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        schedulerProvider = new DefaultScheduler();
    }

    @Test
    public void testExecuteSuccess() {
        GetStoreFeedUseCase storeFeedUseCase = new GetStoreFeedUseCase(storeFeedRepository, mapper, schedulerProvider);

        MockResponseFileReader mockResponseFileReader = new MockResponseFileReader(ApiConstants.STORE_FEED_DOMAIN);
        String content = mockResponseFileReader.getContent();
        StoreFeed storeFeed = new Gson().fromJson(content, StoreFeed.class);
        assertNotNull(storeFeed);
        //mocks
        StoreFeedViewData storeFeedViewData = new StoreFeedViewData();
        Mockito.when(mapper.map(Mockito.any(StoreFeed.class)))
                .thenReturn(storeFeedViewData);
        Mockito.when(storeFeedRepository
                .getStoreFeed(Mockito.any(Location.class), Mockito.anyInt(), Mockito.anyLong())
        ).thenReturn(Observable.just(storeFeed));

        //operation
        storeFeedUseCase.getLiveData().observeForever(observer);
        storeFeedUseCase.execute(new Location(DEFAULT_LATITUDE, DEFAULT_LONGITUDE), LIMIT, offset);

        //verify
        Mockito.verify(observer).onChanged(argumentCaptor.capture());
        Assert.assertNotNull(argumentCaptor.getValue().getData());
        Assert.assertNull(argumentCaptor.getValue().getError());
    }

    @Test
    public void testExecuteFailure() {
        GetStoreFeedUseCase storeFeedUseCase = new GetStoreFeedUseCase(storeFeedRepository, mapper, schedulerProvider);

        MockResponseFileReader mockResponseFileReader = new MockResponseFileReader(ApiConstants.STORE_FEED_DOMAIN);
        String content = mockResponseFileReader.getContent();
        StoreFeed storeFeed = new Gson().fromJson(content, StoreFeed.class);
        assertNotNull(storeFeed);
        //mocks
        Mockito.when(storeFeedRepository
                .getStoreFeed(Mockito.any(Location.class), Mockito.anyInt(), Mockito.anyLong())
        ).thenReturn(Observable.error(new Exception()));

        //operation
        storeFeedUseCase.getLiveData().observeForever(observer);
        storeFeedUseCase.execute(new Location(DEFAULT_LATITUDE, DEFAULT_LONGITUDE), LIMIT, offset);

        //verify
        Mockito.verify(observer).onChanged(argumentCaptor.capture());
        Assert.assertNull(argumentCaptor.getValue().getData());
        Assert.assertNotNull(argumentCaptor.getValue().getError());
        Assert.assertTrue(argumentCaptor.getValue().getError() instanceof Exception);
    }
}