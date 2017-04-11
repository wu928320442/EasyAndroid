package com.wjj.easy.easyandroidHelper.module.main;

import android.net.Uri;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wjj.easy.easyandroidHelper.AppApplication;
import com.wjj.easy.easyandroidHelper.R;
import com.wjj.easy.easyandroidHelper.common.base.BaseActivity;
import com.wjj.easy.easyandroidHelper.module.main.di.DaggerMainComponent;
import com.wjj.easy.easyandroidHelper.module.main.di.MainModule;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainContract.View {


    @BindView(R.id.my_image_view)
    SimpleDraweeView myImageView;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;

    @Inject
    MainPresenter presenter;

    @Override
    protected void init() {
        DaggerMainComponent.builder().aComponent(((AppApplication) getApplication()).getAppComponent()).mainModule(new MainModule(this)).build().inject(this);
        Uri uri = Uri.parse("https://raw.githubusercontent.com/facebook/fresco/gh-pages/static/logo.png");
        myImageView.setImageURI(uri);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void show(String toast) {

    }

    @Override
    public void toast(String msg) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
