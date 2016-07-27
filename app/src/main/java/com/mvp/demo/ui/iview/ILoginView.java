package com.mvp.demo.ui.iview;

/**
 * 创建人：
 * 创建时间： 2016/7/26 14
 * 功能概述: view层的接口，主要定义出view层需要实现的方法。需要去分析view层控件要实现什么，展示什么以及提示什么
 *          登录接口的view层：
 *          账号 EditText
 *          密码 EditText
 *          确认 Button
 *          同时我们考虑一些人性化，安全性的问题。需要去检验账号和密码是否有合法性，字数是否正确，是否需要清空，
 * 修改人：
 * 修改时间：
 */
public interface ILoginView {

    String getAccount(); //获取账号

    String getPwd(); //获取密码

    void clearAccount(); //清除账号

    void clearPwd(); //清除密码

    void showDialog();  //显示进度对话框

    void hideDialog(); //隐藏进度对话框

    void showToast(String result); //提示

    void setResult(String result);
}
