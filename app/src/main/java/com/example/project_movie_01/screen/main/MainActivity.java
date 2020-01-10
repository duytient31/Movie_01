package com.example.project_movie_01.screen.main;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.project_movie_01.R;
import com.example.project_movie_01.base.BaseActivity;
import com.example.project_movie_01.screen.home.HomeFragment;
import com.example.project_movie_01.screen.home.genres.toprated.TopRatedMovieFragment;
import com.example.project_movie_01.screen.option.OptionFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView mBottomNavigationView;
    private HomeFragment mHomeFragment;
    private OptionFragment mOptionFragment;
    private TopRatedMovieFragment mTopRatedMovieFragment;

    @Override
    protected void registerListener() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
        openHomeScreen();
    }

    @Override
    protected void initComponents() {
        mBottomNavigationView = findViewById(R.id.navigation_view);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.menu_home:
                openHomeScreen();
                return true;
            case R.id.menu_option:
                openOptionScreen();
                return true;
            case R.id.menu_fourtive:
                openFourtiveSceen();
                return true;
            default:
                return false;
        }
    }

    private void openOptionScreen() {
        mOptionFragment = new OptionFragment();
        addFragment(mOptionFragment);
    }

    private void openFourtiveSceen() {
        mTopRatedMovieFragment = new TopRatedMovieFragment();
        addFragment(mTopRatedMovieFragment);
    }

    private void openHomeScreen() {
        mHomeFragment = new HomeFragment();
        addFragment(mHomeFragment);
    }

    private void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).addToBackStack(null).commit();
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }
}
