package com.wjj.easy.easyandroidHelper.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.wjj.easy.easyandroid.ui.EasyActivity;
import com.wjj.easy.easyandroidHelper.widget.dialog.DialogLoading;

import butterknife.ButterKnife;

/**
 * Activity业务基类简单实现（不包含Presenter）
 *
 * @author wujiajun
 */

public abstract class SimpleActivity extends EasyActivity {

    protected DialogLoading loading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
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

    protected abstract void initEventAndData();
}
