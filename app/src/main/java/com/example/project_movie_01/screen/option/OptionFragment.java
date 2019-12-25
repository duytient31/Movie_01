package com.example.project_movie_01.screen.option;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.project_movie_01.R;
import com.example.project_movie_01.base.BaseFragment;

public class OptionFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void registerListener() {
    }

    @Override
    protected void initComponents(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_option;
    }
}
