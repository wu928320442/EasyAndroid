package com.wjj.easy.easyandroid.mvp;

/**
 * MVP View层基类
 * 适用范围：在Fragment使用
 * Created by wujiajun on 17/4/13.
 */
public interface EasyBaseViewFrg<T extends EasyBasePresenter> extends EasyBaseView<T> {
    void setPresenter(T presenter);
}
