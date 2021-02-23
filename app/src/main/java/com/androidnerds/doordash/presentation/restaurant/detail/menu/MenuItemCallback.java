package com.androidnerds.doordash.presentation.restaurant.detail.menu;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.androidnerds.doordash.presentation.restaurant.detail.model.CategoryItemViewData;

public class MenuItemCallback extends DiffUtil.ItemCallback<CategoryItemViewData> {

    @Override
    public boolean areItemsTheSame(@NonNull CategoryItemViewData oldItem, @NonNull CategoryItemViewData newItem) {
        return oldItem.getTitle().equals(newItem.getTitle());
    }

    @Override
    public boolean areContentsTheSame(@NonNull CategoryItemViewData oldItem, @NonNull CategoryItemViewData newItem) {
        return oldItem.equals(newItem);
    }
}
