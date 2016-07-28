package com.mvp.demo.net.api;

import com.mvp.demo.model.bean.PersonEntity;
import com.mvp.demo.net.NetContant;

import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 创建人：
 * 创建时间： 2016/7/27 18
 * 功能概述: 登录接口
 * 修改人：
 * 修改时间：
 */
public interface ILoginService {
    @FormUrlEncoded
    @POST("/app/api" + NetContant.LOGIN_URL)  //路径
    Observable<PersonEntity> toLogin(@Field("data") String data);  //类型已Call形式为主，如果写成Observable的话，需要添加RxJava适配器

}
