package com.wjj.easy.easyandroidHelper.module.login;

import com.wjj.easy.easyandroid.mvp.domain.executor.Executor;
import com.wjj.easy.easyandroid.mvp.domain.executor.MainThread;
import com.wjj.easy.easyandroidHelper.module.login.domain.GetVerifyCodeTask;
import com.wjj.easy.easyandroidHelper.module.login.domain.LoginTask;

import javax.inject.Inject;

/**
 * Created by wujiajun on 17/4/7.
 */

public class LoginPresenter implements LoginContract.Presenter {

    @Inject
    LoginContract.View mView;
    @Inject
    Executor threadExecutor;
    @Inject
    MainThread mainThread;
    @Inject
    GetVerifyCodeTask mGetVerifyCodeTask;
    @Inject
    LoginTask mLoginTask;

    @Inject
    public LoginPresenter() {
    }

    @Override
    public void getVerifyCode(String userName, String pwd) {
        mGetVerifyCodeTask.setUserName(userName);
        mGetVerifyCodeTask.setPwd(pwd);
        mGetVerifyCodeTask.setCallback(new GetVerifyCodeTask.Callback() {
            @Override
            public void success() {
                getView().showToast("getVerifyCode success!");
            }

            @Override
            public void fail() {
                getView().showToast("getVerifyCode fail!");
            }
        });
        threadExecutor.execute(mGetVerifyCodeTask);
    }

    @Override
    public void login(String userName, String pwd, String verifyCode) {
        getView().showLoadingDialog();
        mLoginTask.setUserName(userName);
        mLoginTask.setPwd(pwd);
        mLoginTask.setVerifyCode(verifyCode);
        mLoginTask.setCallback(new LoginTask.Callback() {
            @Override
            public void loginSuccess() {
                getView().showToast("login success!");
            }

            @Override
            public void loginFail() {
                getView().showToast("login fail!");
            }
        });
        threadExecutor.execute(mLoginTask);
    }

    @Override
    public void start() {

    }

    public LoginContract.View getView() {
        return mView;
    }
}
