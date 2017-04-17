package com.wjj.easy.easyandroidHelper.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

import com.wjj.easy.easyandroidHelper.R;

import butterknife.ButterKnife;


/**
 * Created by zhaotun
 */
public abstract class BaseDialog extends Dialog {

    protected float mDimAmount = 0.6f;

    protected float mWidthScale = 0.9f;

    protected int gravity = Gravity.CENTER_VERTICAL;

    protected int animId = -1;

    protected int x = 0;

    protected int y = 0;

    protected int h = LayoutParams.WRAP_CONTENT;

    protected boolean mShouldSetWindow = true;


    public BaseDialog(Context context) {
        super(context, R.style.dialog_custom_roll_up_down);
    }

    public BaseDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
        init();

        if (mShouldSetWindow) {
            setWindow(x, y);
        }
    }

    protected void setWindow(int x, int y) {
        Window dialogWindow = getWindow();
        LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = getContext().getResources().getDisplayMetrics(); // 获取屏幕宽、高用
        lp.width = (int) (d.widthPixels * mWidthScale);
        lp.height = h;
        lp.x = x;
        lp.y = y;
        lp.gravity = gravity;
        lp.dimAmount = mDimAmount;
        dialogWindow.addFlags(LayoutParams.FLAG_DIM_BEHIND);

        if (animId != -1) {
            dialogWindow.setWindowAnimations(animId);
        }
    }

    public void shouldSetWindow(boolean shouldSetWindow) {
        this.mShouldSetWindow = shouldSetWindow;
    }

    protected abstract int getContentView();

    protected abstract void init();

}
