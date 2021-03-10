package com.androidnerds.doordash.presentation.storefeed.viewmodel;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.androidnerds.doordash.core.mapper.Mapper;
import com.androidnerds.doordash.core.rx.SchedulerProvider;
import com.androidnerds.doordash.core.utils.Result;
import com.androidnerds.doordash.domain.IStoreFeedRepository;
import com.androidnerds.doordash.domain.model.Location;
import com.androidnerds.doordash.domain.model.StoreFeed;
import com.androidnerds.doordash.domain.usecase.GetStoreFeedUseCase;
import com.androidnerds.doordash.presentation.storefeed.model.StoreFeedViewData;
import com.androidnerds.doordash.rx.DefaultScheduler;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;
import com.google.gson.Gson;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import io.reactivex.rxjava3.core.Observable;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(JUnit4.class)
public class StoreFeedViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();
    StoreFeedViewModel viewModel;
    GetStoreFeedUseCase feedUseCase;
    @Mock
    private Observer<StoreFeedViewData> observer;

    @Captor
    private ArgumentCaptor<StoreFeedViewData> argumentCaptor;
    @Mock
    private IStoreFeedRepository storeFeedRepository;
    private SchedulerProvider schedulerProvider;
    @Mock
    private Mapper<StoreFeed, StoreFeedViewData> mapper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        schedulerProvider = new DefaultScheduler();
        feedUseCase = new GetStoreFeedUseCase(storeFeedRepository, mapper, schedulerProvider);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testStoreFeedFetchSuccess() {
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

        viewModel = new StoreFeedViewModel(feedUseCase);
        viewModel.getStoreFeed()
                .observeForever(observer);
        //verify
        Mockito.verify(observer).onChanged(argumentCaptor.capture());
        Assert.assertNotNull(argumentCaptor.getValue());
    }
}