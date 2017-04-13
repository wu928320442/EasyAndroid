package com.wjj.easy.easyandroidHelper.module.main;

import javax.inject.Inject;

/**
 * Created by wujiajun on 17/4/6.
 */

public class MyPresenter implements MyContract.Presenter {

    @Inject
    MyContract.View view;

    @Inject
    public MyPresenter() {
    }

    @Inject
    @Override
    public void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
