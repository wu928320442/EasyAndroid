package com.wjj.easy.easyandroid.mvp.di.components;

import android.content.Context;

import com.wjj.easy.easyandroid.mvp.di.modules.AppModule;
import com.wjj.easy.easyandroid.mvp.di.scopes.ApplicationScope;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by niuxiaowei on 16/3/19.
 */
@ApplicationScope
@Component(modules = {AppModule.class})
public interface AppComponent {

    Context getContext();

}
