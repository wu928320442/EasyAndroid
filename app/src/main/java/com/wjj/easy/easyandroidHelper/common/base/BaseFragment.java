package com.wjj.easy.easyandroidHelper.common.base;

import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.wjj.easy.easyandroid.mvp.EasyBasePresenter;
import com.wjj.easy.easyandroid.ui.EasyFragment;
import com.wjj.easy.easyandroidHelper.module.dialog.DialogLoading;

import butterknife.ButterKnife;

/**
 * Fragment业务基类
 * Created by wujiajun on 17/4/10.
 */

public abstract class BaseFragment<P extends EasyBasePresenter> extends EasyFragment<P> {

    protected DialogLoading loading;

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this, view);
        loading = new DialogLoading(getActivity());
        init();
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

    protected abstract void init();

}
