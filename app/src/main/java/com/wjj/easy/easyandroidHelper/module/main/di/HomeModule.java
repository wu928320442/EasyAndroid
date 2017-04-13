package com.wjj.easy.easyandroidHelper.module.main.di;

import com.wjj.easy.easyandroidHelper.module.main.HomeContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wujiajun on 17/4/12.
 */
@Module
public class HomeModule {

    HomeContract.View view;

    public HomeModule(HomeContract.View view) {
        this.view = view;
    }

    @Provides
    HomeContract.View provideView() {
        return view;
    }
}
