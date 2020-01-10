package com.example.project_movie_01.screen.home.genres.upcoming;

import com.example.project_movie_01.data.MoviesDataSource;
import com.example.project_movie_01.data.repository.GenresReponsitory;

import java.util.List;

public class UpComingPresenter implements UpComingContract.presenter,
        MoviesDataSource.OnFetchMovieListener {
    private GenresReponsitory mGenresReponsitory;
    private UpComingContract.view mView;

    public UpComingPresenter(GenresReponsitory genresReponsitory, UpComingContract.view view) {
        mGenresReponsitory = genresReponsitory;
        mView = view;
    }

    @Override
    public void getUpComingMovie() {
        mGenresReponsitory.getUpComingMovie(this);
    }

    @Override
    public void onFetchMovieSuccess(List data) {
        mView.onGetUpComingMovieSuccess(data);
    }

    @Override
    public void onFetchMovieFailure(Exception e) {
        mView.onGetUpComingMovieFailure(e.getMessage());
    }
}
