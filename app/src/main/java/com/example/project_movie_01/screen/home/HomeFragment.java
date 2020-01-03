package com.example.project_movie_01.screen.home;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_movie_01.R;
import com.example.project_movie_01.base.BaseFragment;
import com.example.project_movie_01.data.MovieDataSource;
import com.example.project_movie_01.data.model.Popular;
import com.example.project_movie_01.data.source.FetchPopularFromUrl;
import com.example.project_movie_01.screen.search.SearchActivity;
import com.example.project_movie_01.utils.StringUtils;

import java.util.List;

public class HomeFragment extends BaseFragment implements View.OnClickListener,
        MovieDataSource.OnFetchDataListener<Popular> {
    private ImageView mImageViewSearch;
    private RecyclerView mRecyclerViewGenres;
    private HomeAdapter mHomeAdapter;

    @Override
    protected void initComponents(View view) {
        mImageViewSearch = view.findViewById(R.id.image_search);
        mRecyclerViewGenres = view.findViewById(R.id.recyclerView_film_genres);
        FetchPopular();
        FetchNowPlaying();
    }

    private void FetchNowPlaying() {
    }

    private void FetchPopular() {
        FetchPopularFromUrl fetchContactsFromUrl = new FetchPopularFromUrl();
        fetchContactsFromUrl.setListener(this);
        fetchContactsFromUrl.execute(StringUtils.getAPI());
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

    @Override
    public void onFetchDataSuccess(List<Popular> data) {
        mHomeAdapter = new HomeAdapter(data);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewGenres.setLayoutManager(layoutManager);
        mRecyclerViewGenres.setAdapter(mHomeAdapter);
        mHomeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFetchDataFailure(Exception e) {

    }
}
