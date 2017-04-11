package com.wjj.easy.easyandroid.mvp.di.modules;

import android.app.Activity;

import com.wjj.easy.easyandroid.mvp.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * 提供baseactivity的module
 * Created by niuxiaowei on 16/3/20.
 */
@Module
public class ActivityModule {

    private final Activity activity;
    public ActivityModule(Activity activity){
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity(){
        return activity;
    }



}
