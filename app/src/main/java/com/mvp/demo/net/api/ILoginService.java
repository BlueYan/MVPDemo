package com.mvp.demo.net.api;

import com.mvp.demo.net.NetContant;

import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 创建人：
 * 创建时间： 2016/7/27 18
 * 功能概述: 登录接口
 * 修改人：
 * 修改时间：
 */
public interface ILoginService {

    @POST(NetContant.LOGIN_URL)
    String toLogin(@Path("data") String data);

}
