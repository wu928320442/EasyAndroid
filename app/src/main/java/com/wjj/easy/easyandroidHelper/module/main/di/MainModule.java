package com.wjj.easy.easyandroidHelper.module.main.di;

import com.wjj.easy.easyandroidHelper.module.main.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wujiajun on 17/4/7.
 */
@Module
public class MainModule {

    MainContract.View view;

    public MainModule(MainContract.View view) {
        this.view = view;
    }

    @Provides
    MainContract.View provideView() {
        return view;
    }

}
