package com.example.project_movie_01.screen.home.genres;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_movie_01.R;
import com.example.project_movie_01.base.BaseFragment;
import com.example.project_movie_01.screen.home.genres.GenresAdapter;
import com.example.project_movie_01.data.model.Genres;
import com.example.project_movie_01.data.repository.GenresReponsitory;
import com.example.project_movie_01.screen.home.genres.GenresContract;
import com.example.project_movie_01.screen.home.genres.GenresPresenter;
import com.example.project_movie_01.screen.search.SearchActivity;

import java.util.List;

public class NowPlayingMovieFragment extends BaseFragment implements GenresContract.
        view, GenresAdapter.OnClickGenresListener {
    private RecyclerView mRecyclerNowPlaying;
    private RecyclerView mRecyclerPopularMovie;
    private GenresAdapter mGenresAdapter;
    private GenresPresenter mGenresPresenter;

    @Override
    protected void initComponents(View view) {
        mRecyclerNowPlaying = view.findViewById(R.id.recycler_nowplaying_movie);
        mGenresAdapter = new GenresAdapter(this);
        mRecyclerNowPlaying.setAdapter(mGenresAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        mRecyclerNowPlaying.setLayoutManager(layoutManager);

        mGenresPresenter = new GenresPresenter(this, GenresReponsitory.getInstance());
        mGenresPresenter.getNowPlayingMovie();

        mRecyclerPopularMovie = view.findViewById(R.id.recycler_movie_popular);
        mRecyclerPopularMovie.setAdapter(mGenresAdapter);
        mRecyclerPopularMovie.setLayoutManager(layoutManager);
        mGenresPresenter.getNowPlayingMovie();
    }

    @Override
    protected void registerListener() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_nowplaying_movie;
    }

    @Override
    public void onGenresSuccess(List<Genres> nowPlayings) {
        mGenresAdapter.setData(nowPlayings);
        mGenresAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGenresFailure(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickGenresListener(Genres nowPlaying) {
        Intent intent = SearchActivity.getIntent(getActivity());
        startActivity(intent);
    }
}
