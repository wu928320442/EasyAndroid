package com.wjj.easy.easyandroidHelper.common.base;

import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.wjj.easy.easyandroid.ui.EasyFragment;
import com.wjj.easy.easyandroidHelper.widget.dialog.DialogLoading;

import butterknife.ButterKnife;

/**
 * Fragment业务基类(不包含Presenter)
 *
 * @author wujiajun
 */

public abstract class SimpleFragment extends EasyFragment {

    protected DialogLoading loading;

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this, view);
        loading = new DialogLoading(getActivity());
    }

    @Override
    protected void init(View view) {
        initEventAndData();
    }

    @Override
    public void onStart() {
        super.onStart();
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

    protected abstract void initEventAndData();

}
