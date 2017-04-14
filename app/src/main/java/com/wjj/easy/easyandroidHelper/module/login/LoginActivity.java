package com.wjj.easy.easyandroidHelper.module.login;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wjj.easy.easyandroid.mvp.di.modules.ActivityModule;
import com.wjj.easy.easyandroidHelper.AppApplication;
import com.wjj.easy.easyandroidHelper.common.base.BaseActivity;
import com.wjj.easy.easyandroidHelper.R;
import com.wjj.easy.easyandroidHelper.module.dialog.DialogLoading;
import com.wjj.easy.easyandroidHelper.module.login.di.DaggerLoginComponent;
import com.wjj.easy.easyandroidHelper.module.login.di.LoginModule;
import com.wjj.easy.easyandroidHelper.module.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登录Activity
 *
 * @author wujiajun
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
    @BindView(R.id.tool_bar)
    Toolbar toolbar;

    @Override
    protected void init() {
        //设置presenter
        DaggerLoginComponent.builder()
                .aComponent(((AppApplication) getApplication()).getAppComponent())
                .loginModule(new LoginModule(this))
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);

        // App Logo
        toolbar.setLogo(R.mipmap.ic_launcher);
        // Title
        toolbar.setTitle("App Title");
        // Sub Title
        toolbar.setSubtitle("Sub title");

        setSupportActionBar(toolbar);
        //Navigation Icon
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }


    @OnClick({R.id.get_verify_code, R.id.tv_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.get_verify_code:
                getPresenter().getVerifyCode(setUserName.getText().toString(), setPwd.getText().toString());
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.tv_login:
                getPresenter().login(setUserName.getText().toString(), setPwd.getText().toString(), setVerifyCode.getText().toString());
                break;
        }
    }

    public LoginPresenter getPresenter() {
        return mPresenter;
    }
}
