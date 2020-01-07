package com.example.project_movie_01.screen.home.genres.nowplaying;

import com.example.project_movie_01.data.MoviesDataSource;
import com.example.project_movie_01.data.model.Genres;
import com.example.project_movie_01.data.repository.GenresReponsitory;

import java.util.List;

public class NowPlayingMoviePresenter implements NowPlayingMovieContract.presenter,
        MoviesDataSource.OnFetchMovieListener<Genres> {
    private NowPlayingMovieContract.view mView;
    private GenresReponsitory mGenresReponsitory;

    public NowPlayingMoviePresenter(NowPlayingMovieContract.view view, GenresReponsitory genresReponsitory) {
        mView = view;
        mGenresReponsitory = genresReponsitory;
    }

    @Override
    public void getNowPlayingMovie() {
        mGenresReponsitory.getNowPlayingMovieList(this);
    }

    @Override
    public void onFetchMovieSuccess(List<Genres> data) {
        mView.onNowPlayingMovieSucces(data);
    }

    @Override
    public void onFetchMovieFailure(Exception e) {
        mView.onNowPlayingMovieFailure(e.getMessage());
    }
}
