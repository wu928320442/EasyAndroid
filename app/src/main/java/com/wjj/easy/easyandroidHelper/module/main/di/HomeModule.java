package com.wjj.easy.easyandroidHelper.module.main.di;

import android.support.annotation.LayoutRes;

import com.wjj.easy.easyandroidHelper.module.main.HomeContract;
import com.wjj.easy.easyandroidHelper.module.main.HomeFragment;
import com.wjj.easy.easyandroidHelper.module.main.adapter.HomeAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wujiajun on 17/4/12.
 */
@Module
public class HomeModule {

    HomeContract.View view;
    int resId;

    public HomeModule(HomeContract.View view) {
        this.view = view;
    }
    public HomeModule(HomeContract.View view, @LayoutRes int resId) {
        this.view = view;
        this.resId = resId;
    }

    @Provides
    HomeContract.View provideView() {
        return view;
    }

    @Provides
    HomeAdapter provideHomeAdapter() {
        return new HomeAdapter(resId);
    }

    @Provides
    HomeFragment provideHomeFragment(){
        return new HomeFragment();
    }

}
