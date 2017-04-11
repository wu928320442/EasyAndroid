package com.wjj.easy.easyandroidHelper.common.di;

import android.content.Context;

import com.blankj.utilcode.util.Utils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.wjj.easy.easyandroid.http.Http;
import com.wjj.easy.easyandroid.mvp.di.modules.AppModule;
import com.wjj.easy.easyandroid.mvp.domain.executor.Executor;
import com.wjj.easy.easyandroid.mvp.domain.executor.MainThread;
import com.wjj.easy.easyandroid.mvp.domain.executor.impl.MainThreadImpl;
import com.wjj.easy.easyandroid.mvp.domain.executor.impl.ThreadExecutor;
import com.wjj.easy.easyandroidHelper.common.net.ApiService;
import com.wjj.easy.easyandroidHelper.common.net.CookieInterceptor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by wujiajun on 17/4/7.
 */
@Module
public class AModule extends AppModule {

    private Http mHttp;

    public AModule(Context context) {
        super(context);
        initHttp();
        initImage();
        initUtils();
    }

    private void initHttp() {
        //cookie cache & persistor
        ClearableCookieJar cookieJar =
                new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(provideContext()));
        mHttp = new Http.HttpBuilder()
                .setBaseUrl(ApiService.HOST)
                .setCookieJar(cookieJar)
                .setTimeout(15)
                .addInterceptor(new CookieInterceptor())
                .build();
    }

    private void initImage() {
        ImagePipelineConfig config = OkHttpImagePipelineConfigFactory
                .newBuilder(provideContext(), mHttp.getClient())
                .build();
        Fresco.initialize(provideContext(), config);
    }

    private void initUtils() {
        Utils.init(provideContext());
    }

    @Provides
    ApiService provideApiService() {
        return mHttp.getRetrofit().create(ApiService.class);
    }

    @Provides
    Executor provideExecutor() {
        return ThreadExecutor.getInstance();
    }

    @Provides
    MainThread provideMainThread(){
        return MainThreadImpl.getInstance();
    }

}
