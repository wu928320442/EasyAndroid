package com.wjj.easy.easyandroidHelper.module.main;

import com.wjj.easy.easyandroidHelper.R;
import com.wjj.easy.easyandroidHelper.common.base.BaseFragment;

import javax.inject.Inject;

/**
 * 首页
 * Created by wujiajun on 17/4/12.
 */

public class HomeFragment extends BaseFragment implements HomeContract.View {

    HomeContract.Presenter presenter;

    @Override
    protected void init() {
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_home;
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void toast(String msg) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
