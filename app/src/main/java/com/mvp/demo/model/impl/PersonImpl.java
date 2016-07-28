package com.mvp.demo.model.impl;

import com.mvp.demo.model.bean.PersonEntity;
import com.mvp.demo.model.iface.IPerson;
import com.mvp.demo.net.NetContant;
import com.mvp.demo.net.OkHttpImpl;
import com.mvp.demo.net.RetrofitManager;
import com.mvp.demo.net.api.ILoginService;
import com.mvp.demo.net.callback.LoginCallback;
import com.zhy.http.okhttp.OkHttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;
import rx.Subscriber;

/**
 * 创建人：
 * 创建时间： 2016/7/26 11
 * 功能概述: 用户登录实现类
 * 修改人：
 * 修改时间：
 */
public class PersonImpl implements IPerson {


    @Override
    public Observable<PersonEntity> login(final String account, final String pwd) {

        /*Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl("http://120.76.156.9:22354")  //首先baseUrl有格式要求，只能是http后的ip地址或者是域名
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();*/
        ILoginService mILogin = RetrofitManager.mRetrofit.create(ILoginService.class);
        try {
            return mILogin.toLogin(new JSONObject()
                    .put("__userid", "__userid")
                    .put("sign", OkHttpImpl.makeSign("__userid",  NetContant.LOGIN_URL))
                    .put("ltype", "")
                    .put("account", account)
                    .put("password", pwd).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 实现登录，获取上层presenter传递的账号和密码，访问网络，获取网络返回的数据，将其返回到presenter层。
     * @param account
     * @param pwd
     * @param mListener
     */
    @Override
    public void login(String account, String pwd, final ILoginListener mListener) {
        try {
            OkHttpUtils
                    .post()
                    .url(NetContant.HOST_NAME + NetContant.LOGIN_URL)
                    .addParams("data", new JSONObject()
                            .put("__userid", "__userid")
                            .put("sign", OkHttpImpl.makeSign("__userid", NetContant.LOGIN_URL))
                            .put("ltype", "")
                            .put("account", account)
                            .put("password", pwd).toString())
                    .tag(this)
                    .build()
                    .execute(new LoginCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            mListener.loginFailed();
                        }

                        @Override
                        public void onResponse(PersonEntity response, int id) {
                            mListener.loginSuccess(response);
                        }
                    });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
