package com.wjj.easy.easyandroidHelper.module.main.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wjj.easy.easyandroidHelper.R;
import com.wjj.easy.easyandroidHelper.model.ListInfo;

import java.text.NumberFormat;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by ljw on 2017/4/14.
 */

public class HomeAdapter extends BaseQuickAdapter<ListInfo.DataBean,BaseViewHolder> {

    Drawable right_vip;
    Drawable right_free;

    public HomeAdapter(int layoutResId, List<ListInfo.DataBean> data) {
        super(layoutResId, data);
    }

    @Inject
    public HomeAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder holder, ListInfo.DataBean info) {
        if(info==null)
            return;

        SimpleDraweeView ivIcon = holder.getView(R.id.dv_img);
        ivIcon.setImageURI(info.getImageUrl());
        holder.setText(R.id.tv_date, info.getDoTime());
        holder.setText(R.id.tv_city, info.getCity());

        holder.setText(R.id.tv_label, info.getTaskTypeName());

        TextView tv_name = holder.getView(R.id.tv_name);
        TextView tv_member_price = holder.getView(R.id.tv_member_price);


        if(right_vip==null) {
            right_vip = mContext.getResources().getDrawable(R.mipmap.icon_vip_all);
            right_vip.setBounds(0, 0, right_vip.getMinimumWidth(), right_vip.getMinimumHeight());
        }

        if(right_free == null){
            right_free = mContext.getResources().getDrawable(R.mipmap.ic_free);
            right_free.setBounds(0, 0, right_free.getMinimumWidth(), right_free.getMinimumHeight());
        }

        tv_name.setText(info.getTitle());

        if (info.getOnlyVip() == 1){ // 会员专享活动
            tv_name.setCompoundDrawables(null, null, right_vip, null);
            tv_member_price.setVisibility(View.GONE);
            if(info.isIsFree()){ // 免费活动
                holder.setText(R.id.tv_price,"免费报名");
                holder.getView(R.id.tv_price_y).setVisibility(View.GONE);

            }else { // 非免费

                holder.getView(R.id.tv_price_y).setVisibility(View.VISIBLE);
                holder.setText(R.id.tv_price, Integer.toString(info.getHasMemberAmt()));
            }
        }else if(info.isIsFree()){ // 免费活动

            tv_name.setCompoundDrawables(null,null,right_free,null);
            tv_member_price.setVisibility(View.GONE);
            holder.setText(R.id.tv_price,"免费报名");
            tv_member_price.setVisibility(View.GONE);
            holder.getView(R.id.tv_price_y).setVisibility(View.GONE);

        }else { // 普通活动（不是免费活动，也不是会员专享活动）
            holder.setText(R.id.tv_price,info.getAmt());
            holder.getView(R.id.tv_price_y).setVisibility(View.VISIBLE);
            tv_name.setCompoundDrawables(null,null,null,null);
            if(info.getHasMemberAmt() == 1) {
                tv_member_price.setVisibility(View.VISIBLE);
                tv_member_price.setText(String.format("会员价：%s", NumberFormat.getInstance().format(info.getMemberAmt())));
            }
        }
    }
}
