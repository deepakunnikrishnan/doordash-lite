package com.androidnerds.doordash.presentation.restaurant.detail.menu.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnerds.doordash.databinding.RowMenuCategoryBinding;
import com.androidnerds.doordash.presentation.restaurant.detail.menu.MenuItemAdapter;
import com.androidnerds.doordash.presentation.restaurant.detail.model.CategoryItemViewData;
import com.androidnerds.doordash.presentation.restaurant.detail.model.CategoryViewData;
import com.google.android.material.appbar.AppBarLayout;

import java.util.List;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    private RowMenuCategoryBinding binding;

    public CategoryViewHolder(@NonNull RowMenuCategoryBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        initViews();
    }

    private void initViews() {
        binding.menuItemsList.setLayoutManager(new LinearLayoutManager(binding.menuItemsList.getContext(), RecyclerView.VERTICAL, false));
        binding.menuItemsList.addItemDecoration(new DividerItemDecoration(binding.getRoot().getContext(),DividerItemDecoration.VERTICAL));
        binding.menuItemsList.setAdapter(new MenuItemAdapter());
        /*CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) binding.menuItemsList.getLayoutParams();
        layoutParams.setBehavior(new AppBarLayout.ScrollingViewBehavior());*/

    }

    /*private void test() {
        val params: CoordinatorLayout.LayoutParams = yourView.layoutParams as CoordinatorLayout.LayoutParams
        params.behavior = AppBarLayout.ScrollingViewBehavior()
        yourView.requestLayout()
    }*/

    public void bind(CategoryViewData categoryViewData) {
        binding.setCategory(categoryViewData);
        binding.executePendingBindings();
    }

    @BindingAdapter("menuItems")
    public static void setMenuItems(RecyclerView recyclerView, List<CategoryItemViewData> categoryItemViewDataList) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if(adapter instanceof ListAdapter) {
            ((ListAdapter) adapter).submitList(categoryItemViewDataList);
        }
    }


}
