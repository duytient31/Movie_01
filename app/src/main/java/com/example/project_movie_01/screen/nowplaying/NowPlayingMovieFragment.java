package com.example.project_movie_01.screen.nowplaying;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_movie_01.R;
import com.example.project_movie_01.base.BaseFragment;
import com.example.project_movie_01.data.model.NowPlayingMovie;
import com.example.project_movie_01.data.repository.NowPlayingMovieReponsitory;
import com.example.project_movie_01.screen.search.SearchActivity;

import java.util.List;

public class NowPlayingMovieFragment extends BaseFragment implements NowPlayingMovieContract.
        view, NowPlayingMovieAdapter.OnClickNowPlayingListener {
    private RecyclerView mRecyclerNowPlaying;
    private NowPlayingMovieAdapter mNowPlayingMovieAdapter;
    private NowPlayingMoviePresenter mNowPlayingMoviePresenter;

    @Override
    protected void initComponents(View view) {
        mRecyclerNowPlaying = view.findViewById(R.id.recycler_now_playing);
        mNowPlayingMovieAdapter = new NowPlayingMovieAdapter(this);
        mRecyclerNowPlaying.setAdapter(mNowPlayingMovieAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerNowPlaying.setLayoutManager(layoutManager);

        mNowPlayingMoviePresenter = new NowPlayingMoviePresenter(this, NowPlayingMovieReponsitory.getInstance());
        mNowPlayingMoviePresenter.getNowPlayings();
    }

    @Override
    protected void registerListener() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_nowplaying_movie;
    }

    @Override
    public void onNowPlayingSucces(List<NowPlayingMovie> nowPlayings) {
        mNowPlayingMovieAdapter.setData(nowPlayings);
        mNowPlayingMovieAdapter.notifyDataSetChanged();
    }

    @Override
    public void onNowPlayingFailure(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickNowPlayingListener(NowPlayingMovie nowPlaying) {
        Intent intent = SearchActivity.getIntent(getActivity());
        startActivity(intent);
    }
}
