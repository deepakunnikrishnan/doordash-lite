package com.androidnerds.doordash.di.data;

import com.androidnerds.doordash.data.remote.constant.RemoteConstants;
import com.androidnerds.doordash.data.remote.service.StoreDetailService;
import com.androidnerds.doordash.data.remote.service.StoreFeedService;
import com.google.gson.Gson;

import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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


    public static OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        if(null == okHttpClient) {
            okHttpClient = getUnsafeOkHttpClient(loggingInterceptor);
        }
        return okHttpClient;
    }

    public static Retrofit provideRetrofit(String baseUrl, OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory, RxJava3CallAdapterFactory adapterFactory) {
        if(null == retrofit) {
            retrofit  = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addCallAdapterFactory(adapterFactory)
                    .addConverterFactory(gsonConverterFactory)
                    .build();
        }
        return retrofit;
    }

    public static HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor();
    }

    public static GsonConverterFactory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    public static Gson provideGson() {
        return new Gson();
    }

    public static StoreFeedService provideStoreFeedService(Retrofit retrofit) {
        return retrofit.create(StoreFeedService.class);
    }

    public static StoreDetailService provideStoreDetailService(Retrofit retrofit) {
        return retrofit.create(StoreDetailService.class);
    }
}
