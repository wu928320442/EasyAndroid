package com.wjj.easy.easyandroidHelper.module.main;

import com.wjj.easy.easyandroid.mvp.EasyBasePresenter;
import com.wjj.easy.easyandroidHelper.common.base.BaseView;

/**
 * Created by wujiajun on 17/4/6.
 */
public interface MyContract {

    interface View extends BaseView {
    }

    interface Presenter extends EasyBasePresenter<View> {
    }

}
