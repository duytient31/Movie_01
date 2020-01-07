package com.example.project_movie_01.screen.home;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.example.project_movie_01.R;
import com.example.project_movie_01.base.BaseFragment;
import com.example.project_movie_01.screen.search.SearchActivity;

public class HomeFragment extends BaseFragment implements View.OnClickListener{
    private ImageView mImageViewSearch;

    @Override
    protected void initComponents(View view) {
        mImageViewSearch = view.findViewById(R.id.image_search);
    }

    @Override
    protected void registerListener() {
        mImageViewSearch.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_search:
                openScreenSearch();
                break;
            default:
                break;
        }
    }

    private void openScreenSearch() {
        Intent intent = SearchActivity.getIntent((getContext()));
        startActivity(intent);
    }

}
