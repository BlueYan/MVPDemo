package com.mvp.demo.net.impl;

import com.mvp.demo.net.NetContant;
import com.mvp.demo.net.OkHttpImpl;
import com.mvp.demo.net.api.ILoginService;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 创建人：
 * 创建时间： 2016/7/27 18
 * 功能概述:
 * 修改人：
 * 修改时间：
 */
public class LoginServiceImpl {


    public static String login(String account, String pwd) {
        String result = null;
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(NetContant.HOST_NAME)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ILoginService mILogin = mRetrofit.create(ILoginService.class);
        try {
            result = mILogin.toLogin(new JSONObject()
                    .put("__userid", "__userid")
                    .put("sign", OkHttpImpl.makeSign("__userid", NetContant.LOGIN_URL))
                    .put("ltype", "")
                    .put("account", account)
                    .put("password", pwd).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

}
