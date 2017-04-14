package com.wjj.easy.easyandroidHelper.common.base;

import com.wjj.easy.easyandroid.mvp.EasyBasePresenter;
import com.wjj.easy.easyandroid.mvp.EasyBaseView;

/**
 * BaseView业务基类
 * Created by wujiajun on 17/4/14.
 */

public interface BaseView<T extends EasyBasePresenter> extends EasyBaseView<T> {
    void toast(String msg);

    void showLoading();

    void hiddenLoading();
}
