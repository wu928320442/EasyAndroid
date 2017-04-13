package com.wjj.easy.easyandroid.mvp.domain.executor.impl;

import android.os.Handler;
import android.os.Looper;

import com.wjj.easy.easyandroid.mvp.domain.executor.MainThread;


/**
 * MainThread具体实现类
 * 确保Runnable中的内容在主线程中执行
 *
 * @author wujiajun
 */
public class MainThreadImpl implements MainThread {

    private static MainThread sMainThread;

    private Handler mHandler;

    private MainThreadImpl() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }

    public static MainThread getInstance() {
        if (sMainThread == null) {
            sMainThread = new MainThreadImpl();
        }

        return sMainThread;
    }
}
