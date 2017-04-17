package com.wjj.easy.easyandroidHelper.module.main;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.wjj.easy.easyandroidHelper.R;
import com.wjj.easy.easyandroidHelper.common.base.BaseFragment;
import com.wjj.easy.easyandroidHelper.model.ListInfo;
import com.wjj.easy.easyandroidHelper.module.main.adapter.HomeAdapter;

import butterknife.BindView;

/**
 * 首页
 * Created by wujiajun on 17/4/12.
 */

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View {

    @BindView(R.id.rv_list)
    RecyclerView rvList;

    HomeAdapter homeAdapter;

    @Override
    protected int getContentView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initEventAndData() {
        showLoading();
        homeAdapter = new HomeAdapter(R.layout.home_list_item);
        rvList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        // 设置Item添加和移除的动画
        rvList.setItemAnimator(new DefaultItemAnimator());
        rvList.setAdapter(homeAdapter);
        rvList.postDelayed(new Runnable() {
            @Override
            public void run() {
                getPresenter().getList(1);
            }
        }, 1000);
    }

    @Override
    public void showList(ListInfo list) {
        Log.e("HomeFragment", "list : " + list.toString());
        homeAdapter.setNewData(list.getData());
        hiddenLoading();
    }
}
