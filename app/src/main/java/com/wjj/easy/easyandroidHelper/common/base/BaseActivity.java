package com.wjj.easy.easyandroidHelper.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.wjj.easy.easyandroid.ui.EasyActivity;
import com.wjj.easy.easyandroidHelper.module.dialog.DialogLoading;

import butterknife.ButterKnife;

/**
 * Activity业务基类
 * Created by wujiajun on 17/4/10.
 */

public abstract class BaseActivity extends EasyActivity {

    protected DialogLoading loading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        loading = new DialogLoading(this);
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
