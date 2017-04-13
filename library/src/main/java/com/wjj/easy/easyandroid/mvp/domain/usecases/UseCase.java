package com.wjj.easy.easyandroid.mvp.domain.usecases;


/**
 * Domain层中UseCase抽象接口
 *
 * @author wujiajun
 */
public interface UseCase {

    /**
     * UserCase执行方法
     * 可在任何线程执行
     */
    void execute();
}
