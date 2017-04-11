package com.wjj.easy.easyandroid.http;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.wjj.easy.easyandroid.BuildConfig;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * HTTP网络配置
 * 1.OkHttpClient配置
 * 2.Retrofit配置
 * 3.Builder构建初始化数据
 * Created by wujiajun on 17/4/5.
 */
public class Http {

    private static final boolean DEBUG = /*BuildConfig.DEBUG*/true;

    private HttpBuilder mBuilder;
    private OkHttpClient mClient;
    private Retrofit mRetrofit;

    public Http(HttpBuilder builder) {
        mBuilder = builder;
        configOKHttp();
        configRetrofit();
    }

    private void configOKHttp() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (DEBUG) {
            builder.addInterceptor(loggingInterceptor);
        }
        for (Interceptor interceptor : mBuilder.interceptors) {
            builder.addInterceptor(interceptor);
        }
        mClient = builder.retryOnConnectionFailure(true)
                .connectTimeout(mBuilder.timeout, TimeUnit.SECONDS)
                .cookieJar(mBuilder.cookieJar).build();
    }

    private void configRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(mBuilder.baseUrl)
                .client(mClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * HTTP响应回调
     *
     * @param <T> 响应Bean
     */
    public interface HttpCallback<T> {
        /**
         * 成功响应
         *
         * @param t 响应Bean
         */
        void onResponse(T t);

        /**
         * 失败响应
         *
         * @param t 异常
         */
        void onFailure(Throwable t);
    }

    /**
     * Retrofit2 Callback缺省实现
     * 转换业务接口返回数据
     *
     * @param <T>
     */
    public static class CallbackDefault<T> implements Callback<T> {

        HttpCallback<T> httpCallback;

        public CallbackDefault(HttpCallback<T> httpCallback) {
            this.httpCallback = httpCallback;
        }

        @Override
        public void onResponse(Call<T> call, Response<T> response) {
            httpCallback.onResponse(response.body());
        }

        @Override
        public void onFailure(Call<T> call, Throwable t) {
            httpCallback.onFailure(t);
        }
    }

    /**
     * HTTP 构建类
     */
    public static final class HttpBuilder {
        private String baseUrl;
        private ClearableCookieJar cookieJar;
        private long timeout;
        private ArrayList<Interceptor> interceptors = new ArrayList<Interceptor>();

        public HttpBuilder setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public HttpBuilder setCookieJar(ClearableCookieJar cookieJar) {
            this.cookieJar = cookieJar;
            return this;
        }

        public HttpBuilder setTimeout(long timeout) {
            this.timeout = timeout;
            return this;
        }

        public HttpBuilder addInterceptor(Interceptor interceptor) {
            interceptors.add(interceptor);
            return this;
        }

        public Http build() {
            return new Http(this);
        }
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public OkHttpClient getClient() {
        return mClient;
    }
}
