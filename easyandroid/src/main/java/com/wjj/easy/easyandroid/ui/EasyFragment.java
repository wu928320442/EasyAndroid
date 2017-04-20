package com.wjj.easy.easyandroid.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;
import com.wjj.easy.easyandroid.BuildConfig;
import com.wjj.easy.easyandroid.mvp.EasyBasePresenter;
import com.wjj.easy.easyandroid.mvp.EasyBaseView;

import javax.inject.Inject;

/**
 * Created by wujiajun on 17/4/14.
 */

public abstract class EasyFragment extends Fragment implements EasyBaseView {

    private final static String TAG = EasyFragment.class.getSimpleName();
    private final static boolean DEBUG = BuildConfig.DEBUG;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getContentView(), container, false);
        initView(view);
        init(view);
        return view;
    }

    protected abstract void init(View view);

    protected abstract void initView(View view);

    @Override
    public void onStart() {
        super.onStart();
        if (DEBUG) {
            Logger.t(TAG).d("onStart");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (DEBUG) {
            Logger.t(TAG).d("onResume");
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (DEBUG) {
            Logger.t(TAG).d("onPause");
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (DEBUG) {
            Logger.t(TAG).d("onStop");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (DEBUG) {
            Logger.t(TAG).d("onDestroy");
        }
    }

    protected abstract int getContentView();
}
