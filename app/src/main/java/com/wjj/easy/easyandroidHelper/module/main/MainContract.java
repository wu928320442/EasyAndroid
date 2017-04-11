package com.wjj.easy.easyandroidHelper.module.main;

import com.wjj.easy.easyandroid.mvp.BasePresenter;
import com.wjj.easy.easyandroid.mvp.BaseView;

/**
 * Created by wujiajun on 17/4/6.
 */
public interface MainContract {

    interface View extends BaseView<Presenter> {
        void show(String toast);
    }

    interface Presenter extends BasePresenter {
        void add(int a, int b);

        void minus(int a, int b);
    }

}
