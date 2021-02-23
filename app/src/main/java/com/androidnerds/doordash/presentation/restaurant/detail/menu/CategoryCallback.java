package com.androidnerds.doordash.presentation.restaurant.detail.menu;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.androidnerds.doordash.presentation.restaurant.detail.model.CategoryViewData;

public class CategoryCallback extends DiffUtil.ItemCallback<CategoryViewData> {


    @Override
    public boolean areItemsTheSame(@NonNull CategoryViewData oldItem, @NonNull CategoryViewData newItem) {
        return oldItem.getTitle().equals(newItem.getTitle());
    }

    @Override
    public boolean areContentsTheSame(@NonNull CategoryViewData oldItem, @NonNull CategoryViewData newItem) {
        return oldItem.equals(newItem);
    }
}
