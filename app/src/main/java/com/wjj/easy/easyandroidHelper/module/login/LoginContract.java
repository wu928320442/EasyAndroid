package com.wjj.easy.easyandroidHelper.module.login;

import com.wjj.easy.easyandroid.mvp.BasePresenter;
import com.wjj.easy.easyandroid.mvp.BaseView;


/**
 * Created by wujiajun on 17/4/7.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter> {

        void showLoadingDialog();

        void dismissLoadingDialog();

        void showToast(String msg);
    }

    interface Presenter extends BasePresenter {
        void getVerifyCode(String userName, String pwd);

        void login(String userName, String pwd, String verifyCode);
    }
}
