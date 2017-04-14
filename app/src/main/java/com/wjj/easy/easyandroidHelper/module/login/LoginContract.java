package com.wjj.easy.easyandroidHelper.module.login;

import com.wjj.easy.easyandroid.mvp.EasyBasePresenter;
import com.wjj.easy.easyandroid.mvp.EasyBaseView;
import com.wjj.easy.easyandroidHelper.common.base.BaseView;


/**
 * LoginContract
 * Created by wujiajun on 17/4/7.
 */
public interface LoginContract {

    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends EasyBasePresenter {
        void getVerifyCode(String userName, String pwd);

        void login(String userName, String pwd, String verifyCode);
    }
}
