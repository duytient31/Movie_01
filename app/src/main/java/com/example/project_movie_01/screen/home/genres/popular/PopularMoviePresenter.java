package com.example.project_movie_01.screen.home.genres.popular;

import com.example.project_movie_01.data.MoviesDataSource;
import com.example.project_movie_01.data.repository.GenresReponsitory;
import com.example.project_movie_01.data.model.Genres;

import java.util.List;

public class PopularMoviePresenter implements PopularMovieContract.Presenter,
        MoviesDataSource.OnFetchMovieListener<Genres> {
    private PopularMovieContract.View mView;
    private GenresReponsitory mGenresReponsitory;

    public PopularMoviePresenter(PopularMovieContract.View view, GenresReponsitory genresReponsitory) {
        mView = view;
        mGenresReponsitory = genresReponsitory;
    }

    @Override
    public void getPopularMovie() {
        mGenresReponsitory.getPopularMovieList(this);
    }

    @Override
    public void onFetchMovieSuccess(List data) {
        mView.onGetPopularMovieSucces(data);
    }

    @Override
    public void onFetchMovieFailure(Exception e) {
        mView.onGetPoplarMovieFailure(e.getMessage());
    }
}
