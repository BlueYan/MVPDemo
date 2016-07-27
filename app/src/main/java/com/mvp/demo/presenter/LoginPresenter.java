package com.mvp.demo.presenter;

import android.os.Handler;

import com.mvp.demo.model.bean.PersonEntity;
import com.mvp.demo.model.iface.IPerson;
import com.mvp.demo.model.impl.PersonImpl;
import com.mvp.demo.ui.iview.ILoginView;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 创建人：
 * 创建时间： 2016/7/26 14
 * 功能概述: 登录功能的presenter。持有PersonModel，ILoginView对象
 * 修改人：
 * 修改时间：
 * 修改内容：使用RxAndroid来进行线程切换 不控制V层
 */
public class LoginPresenter {

    private static final String TAG = LoginPresenter.class.getSimpleName();

    private ILoginView mLoginView; //持有view层对象

    private Handler mHandler = new Handler();

    private IPerson mIPerson;  //持有model层对象

    public LoginPresenter(ILoginView mILoginView) {
        this.mLoginView = mILoginView;
        mIPerson = new PersonImpl(); //实例化对象，由实现类进行实例
    }

    /**
     * 实现登录的业务逻辑
     */
    public void login() {
//        mLoginView.showDialog(); 由V层自己控制
       /* mIPerson.login(mLoginView.getAccount(), mLoginView.getPwd(), new IPerson.ILoginListener() {
            @Override
            public void loginSuccess(final PersonEntity mPItem) {
                //执行网络请求去登录，登录成功后回调到这里
                //从网络线程切换到UI线程
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //从P层将数据传递给V层，由V层进行显示
//                        mLoginView.hideDialog(); //交由V层自己控制
                        mLoginView.showToast(mPItem.getInfo().getNick_name() + "登录成功");
                        mLoginView.setResult(mPItem.getInfo().getNick_name());
                    }
                });
            }

            @Override
            public void loginFailed() {
                //登录失败回调到这里
//                mLoginView.hideDialog(); //交给V层自己控制
                mLoginView.showToast("登录失败");
                mLoginView.setResult(null);
            }
        });*/

        mIPerson.login(mLoginView.getAccount(), mLoginView.getPwd())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        mLoginView.setResult(s);
                    }
                });


    }


}
