package com.wujie.mywanandroid.net;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
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
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HuangBin on 2018/11/15 10:16.
 * Description：
 */

public class RxRetrofit {

    private static HttpLoggingInterceptor mHttpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static RxRetrofit sRxRetrofit;

    private RxRetrofit(){}

    public static RxRetrofit getInstance() {
        if (sRxRetrofit == null) {
            synchronized (RxRetrofit.class) {
                if (sRxRetrofit == null) {
                    sRxRetrofit = new RxRetrofit();
                }
            }
        }
        return sRxRetrofit;
    }

    private static OkHttpClient sOkHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new SaveCookiesInterceptor())
            .addInterceptor(new ReadCookiesInterceptor())
            .addInterceptor(mHttpLoggingInterceptor)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .sslSocketFactory(getSSLSocketFactory(), new CustomTrustManager())
            .hostnameVerifier(getHostnameVerifier())
            .build();
    private static ApiServer sApiServer;

    public static  <T> T createApi(Class<T> clazz, String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(sOkHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(clazz);
    }

    public void initRetrofit(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(sOkHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        sApiServer = retrofit.create(ApiServer.class);
    }

    public static ApiServer getApi() {
        if (sApiServer == null) {
            throw new IllegalStateException("You must invoke init method first in Application");
        }
        return sApiServer;
    }

    public static SSLSocketFactory getSSLSocketFactory() {
        SSLSocketFactory ssfFactory = null;

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new CustomTrustManager()}, new SecureRandom());

            ssfFactory = sc.getSocketFactory();
        } catch (Exception e) {
        }

        return ssfFactory;
    }

    public static class CustomTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public static HostnameVerifier getHostnameVerifier() {
        HostnameVerifier   hostnameVerifier= new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
        return hostnameVerifier;
    }

}
