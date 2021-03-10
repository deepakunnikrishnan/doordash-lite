package com.androidnerds.doordash.presentation.restaurant.detail.menu;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.androidnerds.doordash.R;
import com.androidnerds.doordash.databinding.RowMenuCategoryBinding;
import com.androidnerds.doordash.presentation.restaurant.detail.menu.viewholder.CategoryViewHolder;
import com.androidnerds.doordash.presentation.restaurant.detail.model.CategoryViewData;

public class CategoryAdapter extends ListAdapter<CategoryViewData, CategoryViewHolder> {


    public CategoryAdapter() {
        super(new CategoryCallback());
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowMenuCategoryBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.row_menu_category, parent, false);
        return new CategoryViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bind(getItem(position));
    }
}
