package com.wjj.easy.easyandroidHelper.common.base;

import com.wjj.easy.easyandroid.mvp.EasyBasePresenter;

/**
 * Fragment业务基类
 * Created by wujiajun on 17/4/14.
 */

public interface BaseViewFrg<T extends EasyBasePresenter> extends BaseView<T> {
    void setPresenter(T presenter);
}
