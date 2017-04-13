package com.wjj.easy.easyandroidHelper.module.main;

import javax.inject.Inject;

/**
 * Created by wujiajun on 17/4/6.
 */

public class HomePresenter implements HomeContract.Presenter {

    @Inject
    HomeContract.View view;

    @Inject
    public HomePresenter() {
    }

    @Override
    public void start() {

    }

    @Inject
    @Override
    public void setupListeners() {
        view.setPresenter(this);
    }
}
