package com.wjj.easy.easyandroidHelper.module.main.di;

import com.wjj.easy.easyandroidHelper.module.main.MyContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wujiajun on 17/4/12.
 */
@Module
public class MyModule {

    MyContract.View view;

    public MyModule(MyContract.View view) {
        this.view = view;
    }

    @Provides
    MyContract.View provideView() {
        return view;
    }
}
