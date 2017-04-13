package com.wjj.easy.easyandroid.mvp.di.components;

import android.app.Activity;

import com.wjj.easy.easyandroid.mvp.di.modules.ActivityModule;
import com.wjj.easy.easyandroid.mvp.di.scopes.ActivityScope;

import dagger.Component;

/**
 * Activity注射组件
 *
 * @author wujiajun
 */
@ActivityScope
@Component(modules = {ActivityModule.class})
public interface ActivityComponent {

    /**
     * 获取注入的Activity
     *
     * @return Activity
     */
    Activity getActivity();
}
