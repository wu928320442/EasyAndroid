package com.wjj.easy.easyandroidHelper.module.main;

import com.wjj.easy.easyandroid.mvp.domain.executor.Executor;
import com.wjj.easy.easyandroid.mvp.domain.usecases.UseCase;
import com.wjj.easy.easyandroidHelper.common.base.BasePresenter;
import com.wjj.easy.easyandroidHelper.model.ListInfo;
import com.wjj.easy.easyandroidHelper.module.main.domain.GetListTask;

import javax.inject.Inject;

/**
 * Created by wujiajun on 17/4/6.
 */

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    @Inject
    GetListTask getListTask;

    @Inject
    public HomePresenter() {

    }

    @Override
    public void getList(int page) {
        getListTask.setIndex(page);
        getListTask.setCallback(new UseCase.Callback<ListInfo>() {
            @Override
            public void success(ListInfo list) {
                getView().showList(list);
            }

            @Override
            public void fail() {
                getView().hiddenLoading();
            }
        });
        getThreadExecutor().execute(getListTask);
    }
}
