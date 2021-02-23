package com.androidnerds.doordash.core.presentation.databinding;

import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ImageDataBindingUtil {

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        if(!TextUtils.isEmpty(url)) {
            Glide.with(imageView)
                    .load(url)
                    .centerCrop()
                    .into(imageView);
        }
    }

}
