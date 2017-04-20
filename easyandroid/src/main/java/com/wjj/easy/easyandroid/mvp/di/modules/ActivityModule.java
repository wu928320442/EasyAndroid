package com.wjj.easy.easyandroid.mvp.di.modules;

import android.app.Activity;

import com.wjj.easy.easyandroid.mvp.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Activity注入提供者Module
 *
 * @author wujiajun
 */
@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * 提供注入Activity
     * 注意ActivityScope的作用 所有依赖于ActivityScope的组件都依赖于Activity的生命周期
     *
     * @return Activity
     */
    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return activity;
    }


}
