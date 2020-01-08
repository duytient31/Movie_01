package com.example.project_movie_01.screen.home.genres.toprated;

import com.example.project_movie_01.data.MoviesDataSource;
import com.example.project_movie_01.data.repository.GenresReponsitory;

import java.util.List;

public class TopRatedMoviePresenter implements TopRatedMovieContract.presenter,
        MoviesDataSource.OnFetchMovieListener {
    private GenresReponsitory mGenresReponsitory;
    private TopRatedMovieContract.view mView;

    public TopRatedMoviePresenter(GenresReponsitory genresReponsitory, TopRatedMovieContract.view view) {
        mGenresReponsitory = genresReponsitory;
        mView = view;
    }

    @Override
    public void getTopRatedMovie() {
        mGenresReponsitory.getTopRatedMovieList(this);
    }

    @Override
    public void onFetchMovieSuccess(List data) {
        mView.onGetTopRatedMovieSuccess(data);
    }

    @Override
    public void onFetchMovieFailure(Exception e) {
        mView.onGetTopRatedMovieFailure(e.getMessage());
    }
}
