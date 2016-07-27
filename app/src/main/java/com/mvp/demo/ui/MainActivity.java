package com.mvp.demo.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mvp.demo.R;
import com.mvp.demo.presenter.LoginPresenter;
import com.mvp.demo.ui.iview.ILoginView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 实现登录接口view
 */

public class MainActivity extends AppCompatActivity implements ILoginView {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.id_et_account)
    EditText mEtAccount;
    @BindView(R.id.id_et_pwd)
    EditText mEtPwd;
    @BindView(R.id.id_bt_login)
    Button mBtLogin;
    @BindView(R.id.id_tv_result)
    TextView mTvResult;

    private ProgressDialog mPDialong;

    private LoginPresenter mLoginPresenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mBtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginPresenter.login();
            }
        });
    }

    @Override
    public String getAccount() {
        return mEtAccount.getText().toString();
    }

    @Override
    public String getPwd() {
        return mEtPwd.getText().toString();
    }

    @Override
    public void clearAccount() {
        mEtAccount.setText("");
    }

    @Override
    public void clearPwd() {
        mEtPwd.setText("");
    }

    @Override
    public void showDialog() { //presenter层持有view接口对象，view层实现，进行回调
        if (mPDialong != null && !mPDialong.isShowing()) {
            mPDialong.show();
        } else {
            mPDialong = ProgressDialog.show(MainActivity.this, null, "登录中...");
        }
    }

    @Override
    public void hideDialog() {
        if (mPDialong != null && mPDialong.isShowing()) {
            mPDialong.dismiss();
        }
    }

    @Override
    public void showToast(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setResult(String result) {
        mTvResult.setText(result);
    }
}
