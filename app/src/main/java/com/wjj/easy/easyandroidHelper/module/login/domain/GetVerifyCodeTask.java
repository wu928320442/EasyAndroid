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

    String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCf/BRlBCplTC/gcMTGhDbPWnn0hr3kjV0JPk8JNaUZuMIaWX5y1YS0A47o4rPbTr28z27WnUAVpCLNO9fPgClyZjhI1NDNlqGjRmAfQPylZZIKpithUIfx29Kv5VsAZABg4r95If4nCpzHAFSGD5VaOKyDNXPwWR9BxyjkPPzwYwIDAQAB";

    String userName;
    String pwd;

    Callback callback;

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
                callback.success();
            }

            @Override
            public void onFailure(Throwable t) {
                callback.fail();
            }
        });
    }

    public interface Callback extends AbstractUseCase.Callback {
        void success();

        void fail();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }
}
