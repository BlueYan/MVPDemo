package com.mvp.demo.model.iface;

import com.mvp.demo.model.bean.PersonEntity;

import rx.Observable;

/**
 * 创建人：
 * 创建时间： 2016/7/26 11
 * 功能概述: 用户登录实体类接口
 * 修改人：
 * 修改时间：
 */
public interface IPerson {

   void login(String account, String pwd, ILoginListener mListener);

//    void login(String account, String pwd);

    Observable<PersonEntity> login(String account, String pwd);

    //不需要回调
    public interface ILoginListener {  //定义出一个接口出来，用于数据回调
        void loginSuccess(PersonEntity mPItem);

        void loginFailed();
    }

}
