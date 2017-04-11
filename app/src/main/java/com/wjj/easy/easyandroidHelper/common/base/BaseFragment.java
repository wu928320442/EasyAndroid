package com.wjj.easy.easyandroidHelper.common.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;
import com.wjj.easy.easyandroidHelper.BuildConfig;

import butterknife.ButterKnife;

/**
 * Created by wujiajun on 17/4/10.
 */

public abstract class BaseFragment extends Fragment {

    private final static String TAG = BaseFragment.class.getSimpleName();
    private final static boolean DEBUG = BuildConfig.DEBUG;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getContentView(), container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if(DEBUG){
            Logger.t(TAG).d("onStart");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(DEBUG){
            Logger.t(TAG).d("onResume");
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(DEBUG){
            Logger.t(TAG).d("onPause");
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if(DEBUG){
            Logger.t(TAG).d("onStop");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(DEBUG){
            Logger.t(TAG).d("onDestroy");
        }
    }

    protected abstract void init();

    protected abstract int getContentView();
}
