package com.wjj.easy.easyandroid.mvp.di.modules;

import android.content.Context;

import com.wjj.easy.easyandroid.mvp.di.scopes.ApplicationScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by niuxiaowei on 16/3/19.
 */
@Module
public class AppModule {

    Context context;

    public AppModule(Context context){
        this.context = context;
    }

    @ApplicationScope
    @Provides
    public Context provideContext(){
        return context;
    }

}
