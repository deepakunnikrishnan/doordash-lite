package com.androidnerds.doordash.data.remote.store;

import com.androidnerds.doordash.data.remote.ApiConfig;
import com.androidnerds.doordash.data.remote.model.menu.detail.MenuDetailDTO;
import com.androidnerds.doordash.data.remote.service.StoreDetailService;
import com.androidnerds.doordash.di.data.RemoteModule;
import com.androidnerds.doordash.rx.DefaultScheduler;
import com.androidnerds.doordash.testconstant.ApiConstants;
import com.androidnerds.doordash.testutils.MockResponseFileReader;

import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class StoreRemoteDataSourceTest {

    private double DEFAULT_LATITUDE = 37.422740;
    private double DEFAULT_LONGITUDE = -122.139956;
    private static final int LIMIT = 50;
    private long offset = 0;

    private MockWebServer mockWebServer;
    private MockResponseFileReader mockResponseFileReader;
    private StoreDetailService storeDetailService;
    private DefaultScheduler schedulerProvider;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockWebServer = new MockWebServer();
        mockWebServer.start(8080);
        schedulerProvider = new DefaultScheduler();

    }

    @After
    public void tearDown() throws Exception {
        mockWebServer.shutdown();
        if (null != mockResponseFileReader) {
            mockResponseFileReader = null;
        }
    }

    @Test
    public void testGetStoreFeedSuccess() throws IOException {
        this.mockResponseFileReader = new MockResponseFileReader(ApiConstants.STORE_MENU_SUCCESS);
        mockWebServer.setDispatcher(new Dispatcher() {
            @NotNull
            @Override
            public MockResponse dispatch(@NotNull RecordedRequest recordedRequest) throws InterruptedException {
                return new MockResponse().setResponseCode(HttpURLConnection.HTTP_OK).setBody(mockResponseFileReader.getContent());
            }
        });
        storeDetailService = RemoteModule.provideStoreDetailService(
                RemoteModule.provideRetrofit(new ApiConfig(ApiConstants.BASE_URL),
                        RemoteModule.provideOkHttpClient(
                                new HttpLoggingInterceptor()
                        ),
                        GsonConverterFactory.create(),
                        RxJava3CallAdapterFactory.create()
                )
        );

        StoreRemoteDataSource storeRemoteDataSource = new StoreRemoteDataSource(storeDetailService, schedulerProvider);
        List<MenuDetailDTO> menuDetailDTOList = storeRemoteDataSource
                .getMenu(662193)
                .blockingGet();

        assertNotNull(menuDetailDTOList);
        assertFalse(menuDetailDTOList.isEmpty());
    }

}