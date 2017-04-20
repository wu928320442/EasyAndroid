package com.wjj.easy.easyandroid.mvp.domain.executor;

/**
 * MainThread定义了一个能够在主线程使用用例执行的接口
 * 举个例子：如果一个用例需要显示一个对象到UI上，能够使用这个确保run执行的内容是在主线程中
 * @author wujiajun
 */
public interface MainThread {

    /**
     * 执行一个Runnable
     * 确保Runnable中的内容在主线程中运行
     *
     * @param runnable
     */
    void post(final Runnable runnable);
}
