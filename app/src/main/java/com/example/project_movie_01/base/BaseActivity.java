package com.example.project_movie_01.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_movie_01.R;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        initComponents();
        registerListener();
    }

    protected abstract void registerListener();

    protected abstract void initComponents();

    protected abstract int getLayoutId();
}
