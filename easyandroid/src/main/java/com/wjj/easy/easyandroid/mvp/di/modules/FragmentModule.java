package com.wjj.easy.easyandroid.mvp.di.modules;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.wjj.easy.easyandroid.mvp.di.scopes.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Activity注入提供者Module
 *
 * @author wujiajun
 */
@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

//    /**
//     * 提供注入Fragment
//     * 注意FragmentScope的作用 所有依赖于FragmentScope的组件都依赖于Fragment的生命周期
//     *
//     * @return Activity
//     */
//    @FragmentScope
//    @Provides
//    Fragment provideFragment() {
//        return fragment;
//    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
