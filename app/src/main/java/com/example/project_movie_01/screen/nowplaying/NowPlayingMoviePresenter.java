package com.example.project_movie_01.screen.nowplaying;

import com.example.project_movie_01.data.MoviesDataSource;
import com.example.project_movie_01.data.model.NowPlayingMovie;
import com.example.project_movie_01.data.repository.NowPlayingMovieReponsitory;

import java.util.List;

public class NowPlayingMoviePresenter implements NowPlayingMovieContract.presenter,
        MoviesDataSource.OnFetchMovieListener<NowPlayingMovie> {
    private NowPlayingMovieContract.view mView;
    private NowPlayingMovieReponsitory mNowPlayingMovieReponsitory;

    public NowPlayingMoviePresenter(NowPlayingMovieContract.view view, NowPlayingMovieReponsitory nowPlayingMovieReponsitory) {
        mView = view;
        mNowPlayingMovieReponsitory = nowPlayingMovieReponsitory;
    }

    @Override
    public void getNowPlayings() {
        mNowPlayingMovieReponsitory.getNowPlayingMovieList(this);
    }

    @Override
    public void onFetchMovieSuccess(List<NowPlayingMovie> data) {
        mView.onNowPlayingSucces(data);
    }

    @Override
    public void onFetchMovieFailure(Exception e) {
        mView.onNowPlayingFailure(e.getMessage());
    }
}
