package com.mvp.demo.model.impl;

import com.mvp.demo.model.bean.PersonEntity;
import com.mvp.demo.model.iface.IPerson;
import com.mvp.demo.net.NetContant;
import com.mvp.demo.net.OkHttpImpl;
import com.mvp.demo.net.callback.LoginCallback;
import com.mvp.demo.net.impl.LoginServiceImpl;
import com.zhy.http.okhttp.OkHttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
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
    public Observable<String> login(final String account, final String pwd) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                String result = LoginServiceImpl.login(account, pwd);
                subscriber.onNext(result);
            }
        });
    }


    /**
     * 实现登录，获取上层presenter传递的账号和密码，访问网络，获取网络返回的数据，将其返回到presenter层。
     * @param account
     * @param pwd
     * @param mListener
     */
   /* @Override
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
    }*/
}
