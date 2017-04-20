package com.wjj.easy.easyandroid.mvp.di.components;

import android.content.Context;

import com.wjj.easy.easyandroid.mvp.di.modules.AppModule;
import com.wjj.easy.easyandroid.mvp.di.scopes.ApplicationScope;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Application注射组件
 *
 * @author wujiajun
 */
@ApplicationScope
@Component(modules = {AppModule.class})
public interface AppComponent {

    Context getContext();

}
