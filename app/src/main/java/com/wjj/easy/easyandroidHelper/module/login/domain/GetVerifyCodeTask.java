package com.wjj.easy.easyandroidHelper.module.login.domain;

import com.wjj.easy.easyandroid.http.Http;
import com.wjj.easy.easyandroid.mvp.domain.usecases.AbstractUseCase;
import com.wjj.easy.easyandroidHelper.common.net.AppHttp;
import com.wjj.easy.easyandroidHelper.model.base.BaseStatus;
import com.wjj.easy.easyandroidHelper.utils.SecretUtils;

import javax.inject.Inject;

/**
 * 获取验证码任务
 *
 * @author wujiajun
 */

public class GetVerifyCodeTask extends AbstractUseCase {

    String publicKey = "11";

    String userName;
    String pwd;

    @Inject
    AppHttp appHttp;

    @Inject
    public GetVerifyCodeTask() {
    }

    @Override
    public void run() {
        appHttp.getVerifyCode(userName, SecretUtils.encryptByPublicKey(pwd, publicKey), new Http.HttpCallback<BaseStatus>() {
            @Override
            public void onResponse(BaseStatus baseStatus) {
                getCallback().success(baseStatus);
            }

            @Override
            public void onFailure(Throwable t) {
                getCallback().fail();
            }
        });
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
