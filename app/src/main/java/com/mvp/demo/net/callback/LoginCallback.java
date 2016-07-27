package com.mvp.demo.net.callback;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mvp.demo.model.bean.PersonEntity;
import com.zhy.http.okhttp.callback.Callback;

import java.lang.reflect.Type;

import okhttp3.Response;

/**
 * 创建人：
 * 创建时间： 2016/7/26 15
 * 功能概述:
 * 修改人：
 * 修改时间：
 */
public abstract class LoginCallback extends Callback<PersonEntity> {

    private static final String TAG = LoginCallback.class.getSimpleName();

    @Override
    public PersonEntity parseNetworkResponse(Response response, int id) throws Exception {
        Gson gson = new Gson();
        Type type = new TypeToken<PersonEntity>() {}.getType();
        PersonEntity mPerson = gson.fromJson(response.body().string(), type);;
        return mPerson;
    }
}
