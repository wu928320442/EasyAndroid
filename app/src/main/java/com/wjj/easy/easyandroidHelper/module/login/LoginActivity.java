package com.wjj.easy.easyandroidHelper.module.login;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wjj.easy.easyandroidHelper.AppApplication;
import com.wjj.easy.easyandroidHelper.common.base.BaseActivity;
import com.wjj.easy.easyandroidHelper.R;
import com.wjj.easy.easyandroidHelper.module.login.di.DaggerLoginComponent;
import com.wjj.easy.easyandroidHelper.module.login.di.LoginModule;
import com.wjj.easy.easyandroidHelper.module.main.MainActivity;

import javax.inject.Inject;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wujiajun on 17/4/7.
 */

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @Inject
    LoginPresenter mPresenter;

    @BindView(R.id.set_user_name)
    EditText setUserName;
    @BindView(R.id.set_pwd)
    EditText setPwd;
    @BindView(R.id.set_verify_code)
    EditText setVerifyCode;
    @BindView(R.id.get_verify_code)
    TextView getVerifyCode;
    @BindView(R.id.tv_login)
    TextView tvLogin;

    @Override
    protected void init() {
        //设置presenter
        DaggerLoginComponent.builder().aComponent(((AppApplication) getApplication()).getAppComponent()).loginModule(new LoginModule(this)).build().inject(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }


    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void dismissLoadingDialog() {

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toast(String msg) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @OnClick({R.id.get_verify_code, R.id.tv_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.get_verify_code:
                mPresenter.getVerifyCode(setUserName.getText().toString(), setPwd.getText().toString());
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.tv_login:
                mPresenter.login(setUserName.getText().toString(), setPwd.getText().toString(), setVerifyCode.getText().toString());
                break;
        }
    }
}
