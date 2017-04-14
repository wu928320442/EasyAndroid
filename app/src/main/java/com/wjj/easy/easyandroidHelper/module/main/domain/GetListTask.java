package com.wjj.easy.easyandroidHelper.module.main.domain;

import com.wjj.easy.easyandroid.http.Http;
import com.wjj.easy.easyandroid.mvp.domain.usecases.AbstractUseCase;
import com.wjj.easy.easyandroidHelper.common.net.AppHttp;
import com.wjj.easy.easyandroidHelper.model.ListInfo;

import javax.inject.Inject;

/**
 * Created by ljw on 2017/4/13.
 */

public class GetListTask extends AbstractUseCase{

    int index;

    @Inject
    AppHttp appHttp;


    @Inject
    public GetListTask() {

    }


    @Override
    public void run() {
        appHttp.getList(index, new Http.HttpCallback<ListInfo>() {
            @Override
            public void onResponse(ListInfo listInfos) {

                getCallback().success(listInfos);

            }

            @Override
            public void onFailure(Throwable t) {

                getCallback().fail();
            }
        });

    }

    public void setIndex(int index) {
        this.index = index;
    }
}
