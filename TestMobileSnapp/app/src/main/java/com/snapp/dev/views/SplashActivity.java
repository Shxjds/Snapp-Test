package com.snapp.dev.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.snapp.dev.R;

/**
 * SHOWS THE SPLASH SCREEN OF THE APPLICATION.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int splashLength = 2000;
        new Handler().postDelayed(() -> {
            Intent mainIntent = new Intent(SplashActivity.this, MenuActivity.class);
            startActivity(mainIntent);
            finish();
        }, splashLength);
    }
}