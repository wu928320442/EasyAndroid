package com.wjj.easy.easyandroidHelper.module.login.di;

import com.wjj.easy.easyandroid.mvp.di.components.ActivityComponent;
import com.wjj.easy.easyandroid.mvp.di.modules.ActivityModule;
import com.wjj.easy.easyandroid.mvp.di.scopes.ActivityScope;
import com.wjj.easy.easyandroidHelper.common.base.BaseActivity;
import com.wjj.easy.easyandroidHelper.common.di.AComponent;
import com.wjj.easy.easyandroidHelper.module.login.LoginActivity;

import dagger.Component;

/**
 * Login注入器
 * Created by wujiajun on 17/4/7.
 */
@ActivityScope
@Component(dependencies = AComponent.class, modules = {LoginModule.class, ActivityModule.class})
public interface LoginComponent extends ActivityComponent {

    void inject(LoginActivity activity);

}
