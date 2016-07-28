package com.mvp.demo.net;

import android.content.Context;

import com.mvp.demo.base.BaseApp;
import com.mvp.demo.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.net.ContentHandler;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 创建人：
 * 创建时间： 2016/7/28 19
 * 功能概述:
 * 修改人：
 * 修改时间：
 */
public class RetrofitManager {

    public static Retrofit mRetrofit = null;

    private static Context mContext;

    /**
     * 配置Retrofit
     * @param baseUrl
     * @return
     */
    public static Retrofit getRetrofitInstance(Context mContext, String baseUrl) {
        if ( mRetrofit == null ) {
            synchronized (RetrofitManager.class) {
                if ( mRetrofit == null ) {
                    RetrofitManager.mContext = mContext;
                    OkHttpClient.Builder mBuilder = new OkHttpClient.Builder();
                    Cache cache = new Cache(Utils.getCacheDir(mContext), 1024 * 1024 * 50);
                    mBuilder.cache(cache).addInterceptor(getCeacheInterceptor());

                    //设置超时
                    mBuilder.connectTimeout(15, TimeUnit.SECONDS);
                    mBuilder.readTimeout(20, TimeUnit.SECONDS);
                    mBuilder.writeTimeout(20, TimeUnit.SECONDS);
                    //错误重连
                    mBuilder.retryOnConnectionFailure(true);

                    OkHttpClient mClient = mBuilder.build();
                    mRetrofit = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .client(mClient)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .build();
                }
            }
        }
        return mRetrofit;
    }

    private static Interceptor getCeacheInterceptor() {
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!Utils.networkIsAvailable(RetrofitManager.mContext)) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (Utils.networkIsAvailable(RetrofitManager.mContext)) {
                    int maxAge = 0;
                    // 有网络时 设置缓存超时时间0个小时
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("mvpdemo")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("nyn")
                            .build();
                }
                return response;
            }
        };
        return cacheInterceptor;
    }

}
