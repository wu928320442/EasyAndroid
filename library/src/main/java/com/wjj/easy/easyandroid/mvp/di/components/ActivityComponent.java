package com.wjj.easy.easyandroid.mvp.di.components;

import android.app.Activity;

import com.wjj.easy.easyandroid.mvp.di.modules.ActivityModule;
import com.wjj.easy.easyandroid.mvp.di.scopes.ActivityScope;

import dagger.Component;

/**
 *
 * Created by niuxiaowei on 16/3/20.
 */
@ActivityScope
@Component(modules = {ActivityModule.class})
public interface ActivityComponent {

    Activity getActivity();
}
