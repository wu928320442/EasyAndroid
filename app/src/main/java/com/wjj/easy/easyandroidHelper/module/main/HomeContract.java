package com.wjj.easy.easyandroidHelper.module.main;

import com.wjj.easy.easyandroid.mvp.EasyBasePresenterFrg;
import com.wjj.easy.easyandroidHelper.common.base.BaseViewFrg;

/**
 * Created by wujiajun on 17/4/6.
 */
public interface HomeContract {

    interface View extends BaseViewFrg<Presenter> {
        void log(String msg);
    }

    interface Presenter extends EasyBasePresenterFrg {
    }

}
