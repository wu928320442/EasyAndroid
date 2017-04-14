package com.wjj.easy.easyandroidHelper.module.main;

import com.wjj.easy.easyandroid.mvp.domain.executor.Executor;
import com.wjj.easy.easyandroid.mvp.domain.usecases.UseCase;
import com.wjj.easy.easyandroidHelper.model.ListInfo;
import com.wjj.easy.easyandroidHelper.module.main.domain.GetListTask;

import javax.inject.Inject;

/**
 * Created by wujiajun on 17/4/6.
 */

public class HomePresenter implements HomeContract.Presenter {

    @Inject
    HomeContract.View view;

    @Inject
    Executor threadExecutor;

    @Inject
    GetListTask getListTask;

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

    @Override
    public void getList(int page) {
        getListTask.setIndex(page);
        getListTask.setCallback(new UseCase.Callback<ListInfo>() {
            @Override
            public void success(ListInfo list) {
                view.showList(list);
            }

            @Override
            public void fail() {
                view.hiddenLoading();
            }
        });
        threadExecutor.execute(getListTask);
    }
}
