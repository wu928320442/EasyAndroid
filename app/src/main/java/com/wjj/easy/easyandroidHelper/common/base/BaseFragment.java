package com.wjj.easy.easyandroidHelper.common.base;

import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.wjj.easy.easyandroid.mvp.EasyBasePresenter;
import com.wjj.easy.easyandroid.mvp.di.modules.FragmentModule;
import com.wjj.easy.easyandroid.ui.EasyFragment;
import com.wjj.easy.easyandroidHelper.AppApplication;
import com.wjj.easy.easyandroidHelper.common.di.DaggerFragmentCommonComponent;
import com.wjj.easy.easyandroidHelper.common.di.FragmentCommonComponent;
import com.wjj.easy.easyandroidHelper.widget.dialog.DialogLoading;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Fragment业务基类
 *
 * @author wujiajun
 */

public abstract class BaseFragment<P extends EasyBasePresenter> extends EasyFragment {

    @Inject
    protected P mPresenter;

    protected DialogLoading loading;

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this, view);
        loading = new DialogLoading(getActivity());
    }

    @Override
    protected void init(View view) {
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
        initEventAndData();
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.start();
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

    protected FragmentCommonComponent getFragmentComponent() {
        return DaggerFragmentCommonComponent.builder()
                .appCommonComponent(((AppApplication) getActivity().getApplication()).getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    protected abstract void initInject();

    protected abstract void initEventAndData();

    public void setPresenter(P presenter) {
        mPresenter = presenter;
    }

    public P getPresenter() {
        return mPresenter;
    }
}
