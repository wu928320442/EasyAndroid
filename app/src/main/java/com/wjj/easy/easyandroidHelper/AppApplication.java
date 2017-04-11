package com.wjj.easy.easyandroidHelper;

import android.app.Application;

import com.wjj.easy.easyandroidHelper.common.di.AComponent;
import com.wjj.easy.easyandroidHelper.common.di.AModule;
import com.wjj.easy.easyandroidHelper.common.di.DaggerAComponent;

/**
 * Created by wujiajun on 17/4/6.
 */

public class AppApplication extends Application {

    AComponent aComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        aComponent = DaggerAComponent.builder().aModule(new AModule(this)).build();
    }

    public AComponent getAppComponent() {
        return aComponent;
    }
}
