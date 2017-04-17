package com.wjj.easy.easyandroidHelper.module.login;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wjj.easy.easyandroidHelper.R;
import com.wjj.easy.easyandroidHelper.common.base.BaseActivity;
import com.wjj.easy.easyandroidHelper.module.main.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登录Activity
 *
 * @author wujiajun
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

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
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initEventAndData() {
        toolbar.setLogo(R.mipmap.icon_app);
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
        toolbar.setTitleMarginStart(getResources().getDimensionPixelSize(R.dimen.padding_size_30));
        setSupportActionBar(toolbar);
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

}
