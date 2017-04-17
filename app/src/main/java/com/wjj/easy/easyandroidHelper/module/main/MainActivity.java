package com.wjj.easy.easyandroidHelper.module.main;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wjj.easy.easyandroidHelper.R;
import com.wjj.easy.easyandroidHelper.common.base.SimpleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 主页
 *
 * @author wujiajun
 */
public class MainActivity extends SimpleActivity {


    private Fragment[] fragments = new Fragment[]{new HomeFragment(), new MyFragment()};

    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @Override
    protected void initEventAndData() {
        viewPager.setAdapter(new MainPageAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setCustomView(R.layout.view_main_tab);
        tabLayout.getTabAt(1).setCustomView(R.layout.view_main_tab);

        selectTab(tabLayout.getTabAt(0));
        unSelectTab(tabLayout.getTabAt(1));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                selectTab(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                unSelectTab(tab);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                selectTab(tab);
            }
        });
        viewPager.setCurrentItem(0);
    }

    private void selectTab(TabLayout.Tab tab) {
        ImageView icon = ButterKnife.findById(tab.getCustomView(), R.id.tab_icon_iv);
        TextView title = ButterKnife.findById(tab.getCustomView(), R.id.tab_title_tv);
        if (tab.getPosition() == 0) {
            icon.setImageResource(R.mipmap.tab_home_selected);
            title.setText(R.string.home_tab);
        } else {
            icon.setImageResource(R.mipmap.tab_user_selected);
            title.setText(R.string.my_tab);
        }
        title.setTextColor(ContextCompat.getColor(this, R.color.black));
    }

    private void unSelectTab(TabLayout.Tab tab) {
        ImageView icon = ButterKnife.findById(tab.getCustomView(), R.id.tab_icon_iv);
        TextView title = ButterKnife.findById(tab.getCustomView(), R.id.tab_title_tv);
        if (tab.getPosition() == 0) {
            icon.setImageResource(R.mipmap.tab_home_unselected);
            title.setText(R.string.home_tab);
        } else {
            icon.setImageResource(R.mipmap.tab_user_unselected);
            title.setText(R.string.my_tab);
        }
        title.setTextColor(ContextCompat.getColor(this, R.color.grey));
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    private class MainPageAdapter extends FragmentPagerAdapter {

        public MainPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }
    }

}
