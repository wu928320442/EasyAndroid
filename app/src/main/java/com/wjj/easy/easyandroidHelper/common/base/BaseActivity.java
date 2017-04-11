package com.wjj.easy.easyandroidHelper.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;
import com.wjj.easy.easyandroidHelper.BuildConfig;

import butterknife.ButterKnife;

/**
 * Created by wujiajun on 17/4/10.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private final static String TAG = BaseActivity.class.getSimpleName();
    private final static boolean DEBUG = BuildConfig.DEBUG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.setDebug(DEBUG);
        ButterKnife.bind(this);
        init();
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (DEBUG) {
            Logger.t(TAG).d("onStart");
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (DEBUG) {
            Logger.t(TAG).d("onRestart");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (DEBUG) {
            Logger.t(TAG).d("onResume");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (DEBUG) {
            Logger.t(TAG).d("onStop");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (DEBUG) {
            Logger.t(TAG).d("onDestroy");
        }
    }

    protected abstract void init();

    protected abstract int getContentView();
}
