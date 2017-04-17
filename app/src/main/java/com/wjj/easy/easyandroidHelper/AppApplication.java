package com.wjj.easy.easyandroidHelper;

import android.app.Application;

import com.wjj.easy.easyandroidHelper.common.di.AppCommonComponent;
import com.wjj.easy.easyandroidHelper.common.di.AppCommonModule;
import com.wjj.easy.easyandroidHelper.common.di.DaggerAppCommonComponent;

/**
 * Created by wujiajun on 17/4/6.
 */

public class AppApplication extends Application {

    AppCommonComponent aComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        aComponent = DaggerAppCommonComponent.builder().appCommonModule(new AppCommonModule(this)).build();
    }

    public AppCommonComponent getAppComponent() {
        return aComponent;
    }
}
