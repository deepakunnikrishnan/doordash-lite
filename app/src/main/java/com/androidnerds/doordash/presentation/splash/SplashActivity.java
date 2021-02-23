package com.androidnerds.doordash.presentation.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.androidnerds.doordash.R;
import com.androidnerds.doordash.presentation.home.HomeActivity;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Splash Screen for the app.
 */
public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Executors.calla
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(HomeActivity.getLaunchIntent(SplashActivity.this));
            finish();
        }, SPLASH_TIME_OUT);
    }
}