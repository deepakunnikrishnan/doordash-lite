package com.androidnerds.doordash.presentation.restaurant.detail.menu.viewholder;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnerds.doordash.databinding.RowMenuItemBinding;
import com.androidnerds.doordash.presentation.restaurant.detail.model.CategoryItemViewData;

public class MenuItemViewHolder extends RecyclerView.ViewHolder {

    RowMenuItemBinding binding;
    public MenuItemViewHolder(@NonNull RowMenuItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(CategoryItemViewData categoryItemViewData) {
        binding.setMenuItem(categoryItemViewData);
        binding.executePendingBindings();
    }


}
