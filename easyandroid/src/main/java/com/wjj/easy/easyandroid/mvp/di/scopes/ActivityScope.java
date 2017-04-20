package com.wjj.easy.easyandroid.mvp.di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Activity域注解
 * 目的是管理域内对象的生命周期
 *
 * @author wujiajun
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
