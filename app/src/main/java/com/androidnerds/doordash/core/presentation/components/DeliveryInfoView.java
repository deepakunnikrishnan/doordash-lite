package com.androidnerds.doordash.core.presentation.components;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

import com.androidnerds.doordash.R;

public class DeliveryInfoView extends ConstraintLayout {

    private TextView textViewDeliveryFee;
    private TextView textViewDeliveryTime;

    public DeliveryInfoView(@NonNull Context context) {
        this(context, null);
    }

    public DeliveryInfoView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DeliveryInfoView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.row_delivery_info, this);
        view.setBackground(ContextCompat.getDrawable(context, R.drawable.item_border));
        int padding = context.getResources().getDimensionPixelSize(R.dimen.default_padding);
        view.setPadding(padding, padding, padding, padding);
        textViewDeliveryFee = view.findViewById(R.id.textViewDeliveryFee);
        textViewDeliveryTime = view.findViewById(R.id.textViewDeliveryTime);
    }

    @BindingAdapter("deliveryFee")
    public static void setDeliveryFee(DeliveryInfoView deliveryInfoView, String deliveryFee) {
        if(!TextUtils.isEmpty(deliveryFee)) {
            deliveryInfoView.textViewDeliveryFee.setText(deliveryFee);
        }

    }

    @BindingAdapter("deliveryTime")
    public static void setDeliveryTime(DeliveryInfoView deliveryInfoView, String deliveryTime) {
        if(!TextUtils.isEmpty(deliveryTime)) {
            deliveryInfoView.textViewDeliveryTime.setText(deliveryTime);
        }
    }
}
