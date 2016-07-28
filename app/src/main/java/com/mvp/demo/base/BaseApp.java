package com.mvp.demo.base;

import android.app.Application;
import android.content.Context;

import com.mvp.demo.net.RetrofitManager;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * 创建人：
 * 创建时间： 2016/7/26 14
 * 功能概述:
 * 修改人：
 * 修改时间：
 */
public class BaseApp extends Application {

    private static final String TAG = BaseApp.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpClient mClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor(TAG))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .build();
        OkHttpUtils.initClient(mClient);

        //初始化
        RetrofitManager.getRetrofitInstance(getApplicationContext(), "http://120.76.156.9:22354");
    }
}
