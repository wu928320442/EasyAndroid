package com.wjj.easy.easyandroid.mvp.di.components;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.wjj.easy.easyandroid.mvp.di.modules.FragmentModule;
import com.wjj.easy.easyandroid.mvp.di.scopes.FragmentScope;

import dagger.Component;

/**
 * Fragment注射组件
 *
 * @author wujiajun
 */
@FragmentScope
@Component(modules = FragmentModule.class)
public interface FragmentComponent {
//    /**
//     * 获取注入的Fragment
//     *
//     * @return
//     */
//    Fragment getFragment();

    Activity getActivity();
}
