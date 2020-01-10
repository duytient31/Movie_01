package com.example.project_movie_01.screen.home.genres.nowplaying;

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
import com.example.project_movie_01.screen.search.SearchActivity;

import java.util.List;

public class NowPlayingMovieFragment extends BaseFragment implements NowPlayingMovieContract.
        view, GenresAdapter.OnClickGenresListener {
    private RecyclerView mRecyclerNowPlaying;
    private GenresAdapter mGenresAdapter;
    private NowPlayingMoviePresenter mNowPlayingMoviePresenter;

    @Override
    protected void initComponents(View view) {
        mRecyclerNowPlaying = view.findViewById(R.id.recycler_nowplaying_movie);
        mGenresAdapter = new GenresAdapter(this);
        mRecyclerNowPlaying.setAdapter(mGenresAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerNowPlaying.setLayoutManager(layoutManager);

        mNowPlayingMoviePresenter = new NowPlayingMoviePresenter(this, GenresReponsitory.getInstance());
        mNowPlayingMoviePresenter.getNowPlayingMovie();
    }

    @Override
    protected void registerListener() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_nowplaying_movie;
    }

    @Override
    public void onNowPlayingMovieSucces(List<Genres> nowPlayings) {
        mGenresAdapter.setData(nowPlayings);
        mGenresAdapter.notifyDataSetChanged();
    }

    @Override
    public void onNowPlayingMovieFailure(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickGenresListener(Genres nowPlaying) {
        Intent intent = SearchActivity.getIntent(getActivity());
        startActivity(intent);
    }
}
