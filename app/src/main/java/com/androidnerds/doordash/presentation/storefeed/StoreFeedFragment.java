package com.androidnerds.doordash.presentation.storefeed;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnerds.doordash.DoorDashApplication;
import com.androidnerds.doordash.R;
import com.androidnerds.doordash.databinding.StoreFeedFragmentBinding;
import com.androidnerds.doordash.presentation.ViewModelFactory;
import com.androidnerds.doordash.presentation.restaurant.detail.RestaurantDetailActivity;
import com.androidnerds.doordash.presentation.storefeed.list.StoreItemDiffUtilCallback;
import com.androidnerds.doordash.presentation.storefeed.list.adapter.StoresListAdapter;
import com.androidnerds.doordash.presentation.storefeed.list.adapter.StoresPagingDataAdapter;
import com.androidnerds.doordash.presentation.storefeed.viewmodel.StoreFeedViewModel;

import javax.inject.Inject;

/**
 * Displays the stores for a specific location as a list.
 * Depends on the {@link StoreFeedViewModel} to provide with the data necessary for the screen.
 */
public class StoreFeedFragment extends Fragment {

    @Inject
    ViewModelFactory viewModelFactory;

    private StoreFeedViewModel mViewModel;
    private StoreFeedFragmentBinding binding;
    private StoresListAdapter listAdapter;
    private StoresPagingDataAdapter pagingDataAdapter;

    public static StoreFeedFragment newInstance() {
        return new StoreFeedFragment();
    }

    public StoreFeedFragment() {

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        ((DoorDashApplication)requireActivity().getApplication()).getAppComponent().inject(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.store_feed_fragment, container, false);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this,
                viewModelFactory
        ).get(StoreFeedViewModel.class);
        setupBannerView();
        setupStoreFeedList();
        bindObserverForStores();
        bindObserverForBannerStatus();
    }

    private void setupBannerView() {
        binding.bannerView.setBannerText("Free Delivery through out the day.");
        binding.bannerView.setOnBannerDismissListener(() -> {
            mViewModel.saveBannerPreference(true);
        });
    }

    /**
     * The fragment subscribes to the viewModel for the data required in the screen.
     */
    private void bindObserverForStores() {
        /*mViewModel.getStoreFeed()
                .observe(getViewLifecycleOwner(), storeFeedViewData -> listAdapter.submitList(storeFeedViewData.getStores()));*/
        mViewModel.getStoreFeed()
                .observe(getViewLifecycleOwner(), storeFeedViewData -> {});
        mViewModel.getStorePagingData()
                .observe(getViewLifecycleOwner(), storeItemViewDataPagingData -> {
                    pagingDataAdapter.submitData(getLifecycle(), storeItemViewDataPagingData);
                });
    }

    private void bindObserverForBannerStatus() {
        mViewModel.getBannerStatus()
                .observe(getViewLifecycleOwner(), status -> {
                    if(status) {
                        binding.bannerView.dismiss();
                    } else {
                        binding.bannerView.show();
                    }
                });
    }

    /**
     * Initializing and binding the store list.
     */
    private void setupStoreFeedList() {
        binding.recyclerViewStores.setLayoutManager(new LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false));
        binding.recyclerViewStores.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));
        pagingDataAdapter = new StoresPagingDataAdapter(new StoreItemDiffUtilCallback(), storeItemViewData -> startActivity(RestaurantDetailActivity.getLaunchIntent(requireActivity(), storeItemViewData.getId())));
        binding.recyclerViewStores.setAdapter(pagingDataAdapter);
        //listAdapter = new StoresListAdapter(new StoreItemDiffUtilCallback(), storeItemViewData -> startActivity(RestaurantDetailActivity.getLaunchIntent(requireActivity(), storeItemViewData.getId())));
        //binding.recyclerViewStores.setAdapter(listAdapter);
    }

}