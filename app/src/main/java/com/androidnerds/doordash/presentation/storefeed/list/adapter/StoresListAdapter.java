package com.androidnerds.doordash.presentation.storefeed.list.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.androidnerds.doordash.R;
import com.androidnerds.doordash.databinding.ItemStoreBinding;
import com.androidnerds.doordash.presentation.storefeed.list.ItemClickListener;
import com.androidnerds.doordash.presentation.storefeed.list.StoreItemDiffUtilCallback;
import com.androidnerds.doordash.presentation.storefeed.list.viewholder.StoreItemViewHolder;
import com.androidnerds.doordash.presentation.storefeed.model.StoreItemViewData;

public class StoresListAdapter extends ListAdapter<StoreItemViewData, StoreItemViewHolder> {

    private ItemClickListener clickListener;


    public StoresListAdapter(StoreItemDiffUtilCallback callback, ItemClickListener clickListener) {
        super(callback);
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public StoreItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStoreBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_store, parent, false);
        binding.setClickListener(clickListener);
        return new StoreItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreItemViewHolder holder, int position) {
        holder.bind(getItem(position));
    }
}
