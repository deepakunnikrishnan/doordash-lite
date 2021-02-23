package com.androidnerds.doordash.presentation.restaurant.detail.menu;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.androidnerds.doordash.R;
import com.androidnerds.doordash.databinding.RowMenuItemBinding;
import com.androidnerds.doordash.presentation.restaurant.detail.menu.viewholder.MenuItemViewHolder;
import com.androidnerds.doordash.presentation.restaurant.detail.model.CategoryItemViewData;
import com.androidnerds.doordash.presentation.restaurant.detail.model.CategoryViewData;

public class MenuItemAdapter extends ListAdapter<CategoryItemViewData, MenuItemViewHolder> {


    public MenuItemAdapter() {
        super(new MenuItemCallback());
    }

    @NonNull
    @Override
    public MenuItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowMenuItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_menu_item, parent, false);
        return new MenuItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItemViewHolder holder, int position) {
        holder.bind(getItem(position));
    }
}
