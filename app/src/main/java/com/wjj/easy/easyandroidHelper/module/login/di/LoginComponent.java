package com.wjj.easy.easyandroidHelper.module.login.di;

import com.wjj.easy.easyandroid.mvp.di.scopes.ActivityScope;
import com.wjj.easy.easyandroidHelper.common.di.AComponent;
import com.wjj.easy.easyandroidHelper.module.login.LoginActivity;

import dagger.Component;

/**
 * Created by wujiajun on 17/4/7.
 */
@ActivityScope
@Component(dependencies = AComponent.class, modules = LoginModule.class)
public interface LoginComponent {

    void inject(LoginActivity loginActivity);

}
