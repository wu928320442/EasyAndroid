package com.wjj.easy.easyandroidHelper.common.net;

import com.wjj.easy.easyandroidHelper.model.ListInfo;
import com.wjj.easy.easyandroidHelper.model.LoginResponse;
import com.wjj.easy.easyandroidHelper.model.base.BaseStatus;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by wujiajun on 17/4/5.
 */

public interface ApiService {

    // 线上
    String HOST = "http://dw.qianbao666.com/";//dcw.qbao.com dw.qianbao666.com


    /**
     * 获取注册验证码
     */
    @FormUrlEncoded
    @POST(HOST + "app/sendSMS.do")
    Call<BaseStatus> getVerifyCode(@Field("username") String username, @Field("password") String pwd);

    /**
     * 用户登录
     */
    @FormUrlEncoded
    @POST(HOST + "app/login.do")
    Call<LoginResponse> login(@Field("username") String username, @Field("password") String pwd, @Field("code") String verifyCode);

    /**
     * 获取列表数据
     */
    @GET("http://baoyue.qbao.com/app/task/list.json")
    Call<ListInfo> getList(@Query("type") int type, @Query("page") int page, @Query("rows") int rows);


}
