package com.androidnerds.doordash.presentation.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.androidnerds.doordash.R;
import com.androidnerds.doordash.databinding.HomeActivityBinding;
import com.androidnerds.doordash.presentation.storefeed.StoreFeedFragment;

/**
 * Main screen for the app.
 * Loads the fragment which shows the actual content of the screen.
 * Sets up the toolbar for the app.
 */
public class HomeActivity extends AppCompatActivity {

    public static Intent getLaunchIntent(Context context) {
        return new Intent(context, HomeActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HomeActivityBinding homeActivityBinding = DataBindingUtil.setContentView(this, R.layout.home_activity);
        setSupportActionBar(homeActivityBinding.toolBar.root);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, StoreFeedFragment.newInstance())
                .commitNow();
        }
    }

}