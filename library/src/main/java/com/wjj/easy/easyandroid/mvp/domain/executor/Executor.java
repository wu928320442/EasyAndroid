package com.wjj.easy.easyandroid.mvp.domain.executor;


import com.wjj.easy.easyandroid.mvp.domain.usecases.AbstractUseCase;

/**
 * Executor抽象接口
 * 目的是专门在后台执行任务
 *
 * @author wujiajun
 */
public interface Executor {

    /**
     * 执行用例的方法
     * 方法会调用用例的run方法，然后调用用例的Start方法，这个方法应该在后台操作，用例可能比较耗时
     *
     * @param interactor
     */
    void execute(final AbstractUseCase interactor);
}
