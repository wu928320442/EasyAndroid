package com.wjj.easy.easyandroidHelper.common.di;

import com.wjj.easy.easyandroid.mvp.di.components.FragmentComponent;
import com.wjj.easy.easyandroid.mvp.di.modules.FragmentModule;
import com.wjj.easy.easyandroid.mvp.di.scopes.FragmentScope;
import com.wjj.easy.easyandroidHelper.module.main.HomeFragment;
import com.wjj.easy.easyandroidHelper.module.main.MyFragment;

import dagger.Component;

/**
 * Fragment注入器
 *
 * @author wujiajun
 */
@FragmentScope
@Component(dependencies = AppCommonComponent.class, modules = {FragmentModule.class})
public interface FragmentCommonComponent extends FragmentComponent {

    void inject(HomeFragment fragment);

    void inject(MyFragment fragment);
}
