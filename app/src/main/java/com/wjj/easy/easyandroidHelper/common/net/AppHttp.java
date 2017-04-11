package com.wjj.easy.easyandroidHelper.common.net;

import com.wjj.easy.easyandroid.http.Http;

import com.wjj.easy.easyandroidHelper.model.LoginResponse;
import com.wjj.easy.easyandroidHelper.model.base.BaseStatus;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by wujiajun on 17/4/5.
 */

public class AppHttp {

    private ApiService apiService;

    @Inject
    public AppHttp(ApiService apiService) {
        this.apiService = apiService;
    }

    public void getVerifyCode(String username, String pwd, final Http.HttpCallback<BaseStatus> callback) {
        Call<BaseStatus> call = apiService.getVerifyCode(username, pwd);
        call.enqueue(new Http.CallbackDefault(callback));
        call.request();
    }

    public void login(String username, String pwd, String verifyCode, final Http.HttpCallback<LoginResponse> callback) {
        Call<LoginResponse> call = apiService.login(username, pwd, verifyCode);
        call.enqueue(new Http.CallbackDefault(callback));
        call.request();
    }
}
