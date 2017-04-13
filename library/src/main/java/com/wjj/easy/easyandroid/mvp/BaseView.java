package com.wjj.easy.easyandroid.mvp;

/**
 * MVP View层基类
 * 适用范围：在Activity使用
 * Created by wujiajun on 17/4/6.
 */
public interface BaseView<T extends BasePresenter> {

    void toast(String msg);

    boolean isFinished();
}
