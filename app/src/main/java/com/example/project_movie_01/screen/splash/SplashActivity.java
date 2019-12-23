package com.example.project_movie_01.screen.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.project_movie_01.R;
import com.example.project_movie_01.base.BaseActivity;
import com.example.project_movie_01.screen.home.HomeActivity;

public class SplashActivity extends BaseActivity {

    private static final long SPLASH_TIME_DELAY = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_DELAY);
    }

    @Override
    protected void registerListener() {

    }

    @Override
    protected void initComponents() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }
}
