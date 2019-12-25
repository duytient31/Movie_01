package com.example.project_movie_01.screen.search;

import android.content.Context;
import android.content.Intent;

import com.example.project_movie_01.R;
import com.example.project_movie_01.base.BaseActivity;

public class SearchActivity extends BaseActivity {

    @Override
    protected void registerListener() {
    }

    @Override
    protected void initComponents() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        return intent;
    }
}
