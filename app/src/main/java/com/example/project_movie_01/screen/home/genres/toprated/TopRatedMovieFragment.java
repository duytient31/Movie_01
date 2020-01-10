package com.example.project_movie_01.screen.home.genres.toprated;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_movie_01.R;
import com.example.project_movie_01.base.BaseFragment;
import com.example.project_movie_01.data.model.Genres;
import com.example.project_movie_01.data.repository.GenresReponsitory;
import com.example.project_movie_01.screen.home.genres.GenresAdapter;
import com.example.project_movie_01.screen.home.genres.GenresContract;
import com.example.project_movie_01.screen.home.genres.GenresPresenter;
import com.example.project_movie_01.screen.search.SearchActivity;

import java.util.List;

public class TopRatedMovieFragment extends BaseFragment implements GenresAdapter.OnClickGenresListener
        , GenresContract.view {
    private RecyclerView mRecyclerViewTopRated;
    private GenresAdapter mGenresAdapter;
    private GenresPresenter mGenresPresenter;

    @Override
    protected void initComponents(View view) {
        mRecyclerViewTopRated = view.findViewById(R.id.recycler_movie_upcoming);
        mGenresAdapter = new GenresAdapter(this);
        mRecyclerViewTopRated.setAdapter(mGenresAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,
                false);
        mRecyclerViewTopRated.setLayoutManager(linearLayoutManager);
        mGenresPresenter = new GenresPresenter(this, GenresReponsitory.
                getInstance());
        mGenresPresenter.getTopRatedMovie();
    }

    @Override
    protected void registerListener() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_toprated_movie;
    }

    @Override
    public void onClickGenresListener(Genres genres) {
        Intent intent = SearchActivity.getIntent(getActivity());
        startActivity(intent);
    }

    @Override
    public void onGenresSuccess(List<Genres> genres) {
        mGenresAdapter.setData(genres);
        mGenresAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGenresFailure(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
