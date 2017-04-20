package com.wjj.easy.easyandroid.mvp.domain.executor.impl;


import com.wjj.easy.easyandroid.mvp.domain.executor.Executor;
import com.wjj.easy.easyandroid.mvp.domain.usecases.AbstractUseCase;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Executor具体实现类
 * 实现用例的执行，用例生命周期的更新
 * 注意它是个单例模式
 *
 * @author wujiajun
 */
public class ThreadExecutor implements Executor {

    // This is a singleton
    private static volatile ThreadExecutor sThreadExecutor;

    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<Runnable>();

    private ThreadPoolExecutor mThreadPoolExecutor;

    private ThreadExecutor() {
        long keepAlive = KEEP_ALIVE_TIME;
        mThreadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                keepAlive,
                TIME_UNIT,
                WORK_QUEUE);
    }

    @Override
    public void execute(final AbstractUseCase interactor) {
        mThreadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                //执行用例逻辑
                interactor.run();
                //更新用例状态
                interactor.onFinished();
            }
        });
    }

    /**
     * Executor实例
     *
     * @return
     */
    public static Executor getInstance() {
        if (sThreadExecutor == null) {
            sThreadExecutor = new ThreadExecutor();
        }

        return sThreadExecutor;
    }
}
