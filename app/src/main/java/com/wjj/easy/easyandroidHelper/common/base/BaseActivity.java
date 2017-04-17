package com.wjj.easy.easyandroidHelper.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.wjj.easy.easyandroid.mvp.EasyBasePresenter;
import com.wjj.easy.easyandroid.mvp.di.modules.ActivityModule;
import com.wjj.easy.easyandroid.ui.EasyActivity;
import com.wjj.easy.easyandroidHelper.AppApplication;
import com.wjj.easy.easyandroidHelper.common.di.ActivityCommonComponent;
import com.wjj.easy.easyandroidHelper.common.di.DaggerActivityCommonComponent;
import com.wjj.easy.easyandroidHelper.widget.dialog.DialogLoading;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Activity业务基类
 * Created by wujiajun on 17/4/10.
 */

public abstract class BaseActivity<P extends EasyBasePresenter> extends EasyActivity {

    protected DialogLoading loading;

    @Inject
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
        initEventAndData();
    }

    protected void initView() {
        ButterKnife.bind(this);
        loading = new DialogLoading(this);
    }

    public void toast(String msg) {
        ToastUtils.showShortToast(msg);
    }

    public void showLoading() {
        loading.show();
    }

    public void hiddenLoading() {
        loading.hide();
    }

    protected ActivityCommonComponent getActivityComponent() {
        return DaggerActivityCommonComponent.builder()
                .appCommonComponent(((AppApplication) getApplication()).getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    public P getPresenter() {
        return mPresenter;
    }

    protected abstract void initInject();

    protected abstract void initEventAndData();
}
