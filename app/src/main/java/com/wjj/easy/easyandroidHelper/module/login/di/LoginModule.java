package com.wjj.easy.easyandroidHelper.module.login.di;

import com.wjj.easy.easyandroidHelper.module.login.LoginContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wujiajun on 17/4/7.
 */
@Module
public class LoginModule {

    LoginContract.View view;

    public LoginModule(LoginContract.View view) {
        this.view = view;
    }

    @Provides
    LoginContract.View provideView(){
        return view;
    }

}
