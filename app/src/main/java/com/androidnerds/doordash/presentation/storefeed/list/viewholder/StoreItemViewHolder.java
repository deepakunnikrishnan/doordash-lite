package com.androidnerds.doordash.presentation.storefeed.list.viewholder;

import androidx.recyclerview.widget.RecyclerView;

import com.androidnerds.doordash.databinding.ItemStoreBinding;
import com.androidnerds.doordash.presentation.storefeed.model.StoreItemViewData;

public class StoreItemViewHolder extends RecyclerView.ViewHolder {

    private ItemStoreBinding binding;

    public StoreItemViewHolder(ItemStoreBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(StoreItemViewData storeItemViewData) {
        binding.setStoreItem(storeItemViewData);
        binding.executePendingBindings();
    }
}
