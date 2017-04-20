package com.wjj.easy.easyandroid.mvp;

/**
 * MVP Presenter层基类
 * 适用范围：在Activity使用
 * Created by wujiajun on 17/4/6.
 */
public interface EasyBasePresenter<V extends EasyBaseView> {
    void start();
    void attachView(V view);
}
