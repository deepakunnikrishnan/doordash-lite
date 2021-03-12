package com.androidnerds.doordash.di.data;

import com.androidnerds.doordash.data.remote.ApiConfig;
import com.androidnerds.doordash.data.remote.constant.RemoteConstants;
import com.androidnerds.doordash.data.remote.service.StoreDetailService;
import com.androidnerds.doordash.data.remote.service.StoreFeedService;
import com.google.gson.Gson;

import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class RemoteModule {


    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;

    public static OkHttpClient getUnsafeOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager)trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            return builder
                    .connectTimeout(60L, TimeUnit.SECONDS)
                    .readTimeout(60L, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor)
            .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Singleton
    @Provides
    public static OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        return getUnsafeOkHttpClient(loggingInterceptor);
        /*if(null == okHttpClient) {
            okHttpClient = getUnsafeOkHttpClient(loggingInterceptor);
        }
        return okHttpClient;*/
    }

    @Singleton
    @Provides
    public static Retrofit provideRetrofit(ApiConfig apiConfig, OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory, RxJava3CallAdapterFactory adapterFactory) {
        /*if(null == retrofit) {
            retrofit  = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addCallAdapterFactory(adapterFactory)
                    .addConverterFactory(gsonConverterFactory)
                    .build();
        }
        return retrofit;*/
        return new Retrofit.Builder()
                .baseUrl(apiConfig.getBaseUrl())
                .client(okHttpClient)
                .addCallAdapterFactory(adapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }
    @Singleton
    @Provides
    public static ApiConfig provideApiConfig() {
        return new ApiConfig(RemoteConstants.API_BASE_URL);
    }

    @Provides
    public static HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Singleton
    @Provides
    public static GsonConverterFactory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Singleton
    @Provides
    public static RxJava3CallAdapterFactory provideRxJava3CallAdapterFactory() {
        return RxJava3CallAdapterFactory.create();
    }

    @Singleton
    @Provides
    public static Gson provideGson() {
        return new Gson();
    }

    @Provides
    public static StoreFeedService provideStoreFeedService(Retrofit retrofit) {
        return retrofit.create(StoreFeedService.class);
    }

    @Provides
    public static StoreDetailService provideStoreDetailService(Retrofit retrofit) {
        return retrofit.create(StoreDetailService.class);
    }
}
