package com.androidnerds.doordash.presentation.restaurant.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnerds.doordash.R;
import com.androidnerds.doordash.core.presentation.components.VerticalSpaceItemDecoration;
import com.androidnerds.doordash.databinding.ActivityRestaurantDetailBinding;
import com.androidnerds.doordash.di.PresentationModule;
import com.androidnerds.doordash.presentation.restaurant.detail.menu.CategoryAdapter;
import com.androidnerds.doordash.presentation.restaurant.detail.viemodel.RestaurantDetailViewModel;

/**
 * Activity displaying the Detail screen for the Restaurant.
 * Depends on the {@link RestaurantDetailViewModel} for the data.
 */
public class RestaurantDetailActivity extends AppCompatActivity {

    private static final String EXTRA_STORE_ID = "storeId";

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.6f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION = 200;

    private boolean mIsTheTitleVisible = false;
    private boolean mIsTheTitleContainerVisible = true;

    private ActivityRestaurantDetailBinding binding;

    RestaurantDetailViewModel restaurantDetailViewModel;
    private CategoryAdapter categoryAdapter;

    /**
     * Intent for launching the Restaurant Detail screen.
     *
     * @param context
     * @param id
     * @return
     */
    public static Intent getLaunchIntent(Context context, long id) {
        Intent intent = new Intent(context, RestaurantDetailActivity.class);
        intent.putExtra(EXTRA_STORE_ID, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant_detail);
        setupActionBar();
        setupMenuList();
        observeForStoreDetails();
        startAlphaAnimation(binding.toolBarTitle, 0, View.INVISIBLE);

    }

    /**
     * Observing the livedata of the viewmodel for the data.
     */
    private void observeForStoreDetails() {
        long storeId = getIntent().getLongExtra(EXTRA_STORE_ID, -1);
        restaurantDetailViewModel = PresentationModule.provideRestaurantDetailViewModelFactory(this, storeId)
                .create(RestaurantDetailViewModel.class);
        restaurantDetailViewModel.getStoreDetail()
                .observe(this, storeDetailViewData -> {
                    categoryAdapter.submitList(storeDetailViewData.getCategories());
                    binding.setStoreDetailViewData(storeDetailViewData);
                    binding.executePendingBindings();

                });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setupMenuList() {
        categoryAdapter = new CategoryAdapter();
        binding.recyclerViewStoreDetail.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        binding.recyclerViewStoreDetail.addItemDecoration(new VerticalSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.item_spacing)));
        binding.recyclerViewStoreDetail.setAdapter(categoryAdapter);
    }

    private void setupActionBar() {
        setSupportActionBar(binding.toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        binding.collapsingToolbarLayout.setCollapsedTitleGravity(Gravity.CENTER);
        binding.collapsingToolbarLayout.setExpandedTitleGravity(Gravity.START | Gravity.BOTTOM);
        binding.collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.ToolbarTitleCollapsedAppearance);
        binding.collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ToolbarTitleExpandedAppearance);
        binding.appBar.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            int maxScroll = appBarLayout.getTotalScrollRange();
            float percentage = (float) Math.abs(verticalOffset) / (float) maxScroll;
            handleAlphaOnTitle(percentage);
            handleToolbarTitleVisibility(percentage);
        });
    }

    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if (mIsTheTitleContainerVisible) {
                startAlphaAnimation(binding.titleContainer, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
            }
        } else {
            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(binding.titleContainer, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }

    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if (!mIsTheTitleVisible) {
                startAlphaAnimation(binding.toolBarTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(binding.toolBarTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
            }
        }
    }

    public static void startAlphaAnimation(View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }

}