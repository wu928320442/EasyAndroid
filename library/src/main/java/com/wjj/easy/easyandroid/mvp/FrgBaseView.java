package com.wjj.easy.easyandroid.mvp;

/**
 * MVP View层基类
 * 适用范围：在Fragment使用
 * Created by wujiajun on 17/4/13.
 */
public interface FrgBaseView<T extends BasePresenter> extends BaseView {
    void setPresenter(T presenter);
}
