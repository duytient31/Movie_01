package com.example.project_movie_01.screen.home.genres;

import com.example.project_movie_01.data.MoviesDataSource;
import com.example.project_movie_01.data.model.Genres;
import com.example.project_movie_01.data.repository.GenresReponsitory;

import java.util.List;

public class GenresPresenter implements GenresContract.presenter,
        MoviesDataSource.OnFetchMovieListener<Genres> {
    private GenresContract.view mView;
    private GenresReponsitory mGenresReponsitory;

    public GenresPresenter(GenresContract.view view, GenresReponsitory genresReponsitory) {
        mView = view;
        mGenresReponsitory = genresReponsitory;
    }

    @Override
    public void getNowPlayingMovie() {
        mGenresReponsitory.getNowPlayingMovieList(this);
    }

    @Override
    public void getTopRatedMovie() {
        mGenresReponsitory.getTopRatedMovieList(this);
    }

    @Override
    public void getPopularMovie() {
        mGenresReponsitory.getPopularMovieList(this);
    }

    @Override
    public void getUpComingMovie() {
        mGenresReponsitory.getUpComingMovie(this);
    }

    @Override
    public void onFetchMovieSuccess(List<Genres> data) {
        mView.onGenresSuccess(data);
    }

    @Override
    public void onFetchMovieFailure(Exception e) {
        mView.onGenresFailure(e.getMessage());
    }

}
