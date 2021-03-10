package com.androidnerds.doordash.presentation.storefeed.list;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.androidnerds.doordash.presentation.storefeed.model.StoreItemViewData;

public class StoreItemDiffUtilCallback extends DiffUtil.ItemCallback<StoreItemViewData> {

    @Override
    public boolean areItemsTheSame(@NonNull StoreItemViewData oldItem, @NonNull StoreItemViewData newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull StoreItemViewData oldItem, @NonNull StoreItemViewData newItem) {
        return oldItem.equals(newItem);
    }
}
