package com.androidnerds.doordash.presentation.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.androidnerds.doordash.R;
import com.androidnerds.doordash.databinding.HomeActivityBinding;
import com.androidnerds.doordash.presentation.storefeed.StoreFeedFragment;

public class HomeActivity extends AppCompatActivity {

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