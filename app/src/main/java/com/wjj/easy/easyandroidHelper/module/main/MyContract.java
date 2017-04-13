package com.wjj.easy.easyandroidHelper.module.main;

import com.wjj.easy.easyandroid.mvp.FrgBasePresenter;
import com.wjj.easy.easyandroid.mvp.FrgBaseView;

/**
 * Created by wujiajun on 17/4/6.
 */
public interface MyContract {

    interface View extends FrgBaseView<Presenter> {
    }

    interface Presenter extends FrgBasePresenter {
    }

}
