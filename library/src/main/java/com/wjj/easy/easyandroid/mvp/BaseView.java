package com.wjj.easy.easyandroid.mvp;

/**
 * Created by wujiajun on 17/4/6.
 */
public interface BaseView<T extends BasePresenter> {

//    void setPresenter(T presenter);

    void toast(String msg);

    boolean isFinished();
}
