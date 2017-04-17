package com.wjj.easy.easyandroidHelper.common.di;

import com.wjj.easy.easyandroid.mvp.di.components.ActivityComponent;
import com.wjj.easy.easyandroid.mvp.di.modules.ActivityModule;
import com.wjj.easy.easyandroid.mvp.di.scopes.ActivityScope;
import com.wjj.easy.easyandroidHelper.module.login.LoginActivity;
import com.wjj.easy.easyandroidHelper.module.main.MainActivity;

import dagger.Component;

/**
 * Activity注入器
 * @author wujiajun
 */
@ActivityScope
@Component(dependencies = AppCommonComponent.class, modules = {ActivityModule.class})
public interface ActivityCommonComponent extends ActivityComponent {

    void inject(LoginActivity activity);

    void inject(MainActivity activity);
}
