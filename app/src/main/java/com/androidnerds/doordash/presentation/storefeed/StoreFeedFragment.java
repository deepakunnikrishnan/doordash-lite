package com.androidnerds.doordash.presentation.storefeed;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidnerds.doordash.R;
import com.androidnerds.doordash.databinding.StoreFeedFragmentBinding;
import com.androidnerds.doordash.di.PresentationModule;
import com.androidnerds.doordash.presentation.restaurant.detail.RestaurantDetailActivity;
import com.androidnerds.doordash.presentation.storefeed.list.ItemClickListener;
import com.androidnerds.doordash.presentation.storefeed.list.StoreItemDiffUtilCallback;
import com.androidnerds.doordash.presentation.storefeed.list.adapter.StoresListAdapter;
import com.androidnerds.doordash.presentation.storefeed.model.StoreItemViewData;
import com.androidnerds.doordash.presentation.storefeed.viewmodel.StoreFeedViewModel;
import com.androidnerds.doordash.presentation.storefeed.viewmodel.StoreFeedViewModelFactory;

public class StoreFeedFragment extends Fragment {

    private StoreFeedViewModel mViewModel;
    private StoreFeedFragmentBinding binding;
    private StoresListAdapter listAdapter;

    public static StoreFeedFragment newInstance() {
        return new StoreFeedFragment();
    }

    public StoreFeedFragment(){

    }

    @Override
    public void onAttach(@NonNull Context context) {

        super.onAttach(context);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.store_feed_fragment, container, false);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this,
                PresentationModule.provideStoreFeedViewModelFactory(requireActivity())
        ).get(StoreFeedViewModel.class);
        setupStoreFeedList();
        bindObserverForStores();
    }

    private void bindObserverForStores() {
        mViewModel.getStoreFeed()
                .observe(getViewLifecycleOwner(), storeFeedViewData -> listAdapter.submitList(storeFeedViewData.getStores()));
    }

    private void setupStoreFeedList() {
        binding.recyclerViewStores.setLayoutManager(new LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false));
        binding.recyclerViewStores.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));
        listAdapter = new StoresListAdapter(new StoreItemDiffUtilCallback(), new ItemClickListener() {
            @Override
            public void onItemClicked(StoreItemViewData storeItemViewData) {
                startActivity(RestaurantDetailActivity.getLaunchIntent(requireActivity(), storeItemViewData.getId()));
            }
        });
        binding.recyclerViewStores.setAdapter(listAdapter);
    }

}