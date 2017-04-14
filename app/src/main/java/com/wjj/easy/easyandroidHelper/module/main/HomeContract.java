package com.wjj.easy.easyandroidHelper.module.main;

import com.wjj.easy.easyandroid.mvp.EasyBasePresenterFrg;
import com.wjj.easy.easyandroidHelper.common.base.BaseViewFrg;
import com.wjj.easy.easyandroidHelper.model.ListInfo;

/**
 * Created by wujiajun on 17/4/6.
 */
public interface HomeContract {

    interface View extends BaseViewFrg<Presenter> {
        void showList(ListInfo list);
    }

    interface Presenter extends EasyBasePresenterFrg {
        void getList(int index);
    }

}
