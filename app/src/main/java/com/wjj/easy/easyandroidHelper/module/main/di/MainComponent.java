package com.wjj.easy.easyandroidHelper.module.main.di;

import com.wjj.easy.easyandroid.mvp.di.scopes.ActivityScope;
import com.wjj.easy.easyandroidHelper.common.di.AComponent;
import com.wjj.easy.easyandroidHelper.module.main.MainActivity;

import dagger.Component;

/**
 * Created by wujiajun on 17/4/7.
 */
@ActivityScope
@Component(dependencies = AComponent.class, modules = {HomeModule.class, MyModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

}
