package com.wjj.easy.easyandroidHelper.module.login.domain;

import com.wjj.easy.easyandroid.http.Http;
import com.wjj.easy.easyandroid.mvp.domain.usecases.AbstractUseCase;
import com.wjj.easy.easyandroidHelper.common.net.AppHttp;
import com.wjj.easy.easyandroidHelper.model.LoginResponse;
import com.wjj.easy.easyandroidHelper.utils.SecretUtils;

import javax.inject.Inject;

/**
 * 登录任务
 *
 * @author wujiajun
 */

public class LoginTask extends AbstractUseCase {

    String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCf/BRlBCplTC/gcMTGhDbPWnn0hr3kjV0JPk8JNaUZuMIaWX5y1YS0A47o4rPbTr28z27WnUAVpCLNO9fPgClyZjhI1NDNlqGjRmAfQPylZZIKpithUIfx29Kv5VsAZABg4r95If4nCpzHAFSGD5VaOKyDNXPwWR9BxyjkPPzwYwIDAQAB";

    String userName;
    String pwd;
    String verifyCode;

    @Inject
    AppHttp appHttp;

    @Inject
    public LoginTask() {
    }

    @Override
    public void run() {
        appHttp.login(userName, SecretUtils.encryptByPublicKey(pwd, publicKey), verifyCode, new Http.HttpCallback<LoginResponse>() {
            @Override
            public void onResponse(LoginResponse baseStatus) {
                getCallback().success();
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

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

}
