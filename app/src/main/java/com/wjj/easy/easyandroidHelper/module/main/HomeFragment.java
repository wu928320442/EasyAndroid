package com.wjj.easy.easyandroidHelper.module.main;

import com.blankj.utilcode.util.LogUtils;
import com.wjj.easy.easyandroidHelper.R;
import com.wjj.easy.easyandroidHelper.common.base.BaseFragment;

/**
 * 首页
 * Created by wujiajun on 17/4/12.
 */

public class HomeFragment extends BaseFragment<HomeContract.Presenter> implements HomeContract.View {

    @Override
    protected void init() {
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_home;
    }

    @Override
    public void log(String msg) {
        LogUtils.d(msg);
    }
}
