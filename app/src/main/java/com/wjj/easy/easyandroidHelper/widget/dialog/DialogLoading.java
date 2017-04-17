package com.wjj.easy.easyandroidHelper.widget.dialog;

import android.content.Context;
import android.widget.TextView;

import com.wjj.easy.easyandroidHelper.R;

import butterknife.BindView;


/**
 * Created by zhaotun on 2017/2/21.
 */

public class DialogLoading extends BaseDialog {

    @BindView(R.id.tv_loading_text)
    TextView tvText;

    public DialogLoading(Context context) {
        this(context, false);
    }

    public DialogLoading(Context context, boolean shouldSetWindow) {
        super(context, R.style.customDialog_loading);
        shouldSetWindow(shouldSetWindow);

        setCanceledOnTouchOutside(false);
        setCancelable(true);
    }

    @Override
    protected int getContentView() {
        return R.layout.dialog_loading;
    }

    @Override
    protected void init() {

    }

    public void setText(String text) {
        if (tvText != null) {
            tvText.setText(text);
        }
    }
}
