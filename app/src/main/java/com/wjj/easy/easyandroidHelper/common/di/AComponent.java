package com.wjj.easy.easyandroidHelper.common.di;

import com.wjj.easy.easyandroid.mvp.di.components.AppComponent;
import com.wjj.easy.easyandroid.mvp.di.scopes.ApplicationScope;
import com.wjj.easy.easyandroid.mvp.domain.executor.Executor;
import com.wjj.easy.easyandroid.mvp.domain.executor.MainThread;
import com.wjj.easy.easyandroidHelper.common.net.ApiService;

import dagger.Component;

/**
 * Created by wujiajun on 17/4/7.
 */
@ApplicationScope
@Component(modules = AModule.class)
public interface AComponent extends AppComponent {
    ApiService getApiService();

    Executor getExecutor();

    MainThread getMainThread();
}
