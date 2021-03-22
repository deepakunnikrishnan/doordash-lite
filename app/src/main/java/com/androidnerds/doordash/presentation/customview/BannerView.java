package com.androidnerds.doordash.presentation.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;

import com.androidnerds.doordash.R;
import com.androidnerds.doordash.databinding.LayoutBannerBinding;

public class BannerView extends ConstraintLayout {

    public interface OnBannerDismissListener {

        void onDismissed();
    }

    private LayoutBannerBinding bannerBinding;
    private OnBannerDismissListener dismissListener;

    public BannerView(@NonNull Context context) {
        this(context, null);
    }

    public BannerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public BannerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        bannerBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_banner, this, true);
        initCloseButton();
    }

    private void initCloseButton() {
        bannerBinding.imageButtonClose.setOnClickListener(v -> {
            if(null != dismissListener) {
                setVisibility(View.GONE);
                dismissListener.onDismissed();
            }
        });
    }

    public void setBannerText(String text) {
        bannerBinding.textViewBannerLabel.setText(text);
    }

    public void setOnBannerDismissListener(OnBannerDismissListener listener) {
        this.dismissListener = listener;
    }

    public void dismiss() {
        setVisibility(View.GONE);
    }

    public  void show() {
        setVisibility(View.VISIBLE);
    }

}
