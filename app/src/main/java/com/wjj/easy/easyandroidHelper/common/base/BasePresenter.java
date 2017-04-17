package com.wjj.easy.easyandroidHelper.common.base;

import com.wjj.easy.easyandroid.mvp.EasyBasePresenter;
import com.wjj.easy.easyandroid.mvp.EasyBaseView;
import com.wjj.easy.easyandroid.mvp.domain.executor.Executor;
import com.wjj.easy.easyandroid.mvp.domain.executor.MainThread;

import javax.inject.Inject;

/**
 * Presenter基类
 *
 * @author wujiajun
 */

public class BasePresenter<V extends EasyBaseView> implements EasyBasePresenter<V> {

    protected V mView;

    @Inject
    Executor threadExecutor;
    @Inject
    MainThread mainThread;

    @Override
    public void start() {

    }

    public void attachView(V view) {
        mView = view;
    }

    public V getView() {
        return mView;
    }

    public Executor getThreadExecutor() {
        return threadExecutor;
    }
}
