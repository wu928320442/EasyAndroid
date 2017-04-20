package com.wjj.easy.easyandroid.mvp.di.modules;

import android.content.Context;

import com.wjj.easy.easyandroid.mvp.di.scopes.ApplicationScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Application注入提供者Module
 *
 * @author wujiajun
 */
@Module
public class AppModule {

    Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @ApplicationScope
    @Provides
    public Context provideContext() {
        return context;
    }

}
