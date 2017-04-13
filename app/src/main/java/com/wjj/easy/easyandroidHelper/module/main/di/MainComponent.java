package com.wjj.easy.easyandroidHelper.module.main.di;

import com.wjj.easy.easyandroid.mvp.di.components.ActivityComponent;
import com.wjj.easy.easyandroid.mvp.di.modules.ActivityModule;
import com.wjj.easy.easyandroid.mvp.di.scopes.ActivityScope;
import com.wjj.easy.easyandroidHelper.common.di.AComponent;
import com.wjj.easy.easyandroidHelper.module.main.MainActivity;

import dagger.Component;

/**
 * Created by wujiajun on 17/4/7.
 */
@ActivityScope
@Component(dependencies = AComponent.class, modules = {HomeModule.class, MyModule.class, ActivityModule.class})
public interface MainComponent extends ActivityComponent {

    void inject(MainActivity mainActivity);

}
