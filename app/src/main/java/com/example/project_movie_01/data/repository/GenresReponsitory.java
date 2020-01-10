package com.example.project_movie_01.data.repository;

import com.example.project_movie_01.data.MoviesDataSource;
import com.example.project_movie_01.data.source.GenresDataSource;

public class GenresReponsitory {
    private static GenresReponsitory sInstance;
    private GenresDataSource mGenresDataSource;

    private GenresReponsitory(GenresDataSource genresDataSource) {
        mGenresDataSource = genresDataSource;
    }

    public static GenresReponsitory getInstance() {
        if (sInstance == null) {
            sInstance = new GenresReponsitory(GenresDataSource.getInstance());
        }
        return sInstance;
    }

    public void getNowPlayingMovieList(MoviesDataSource.OnFetchMovieListener listener) {
        mGenresDataSource.getMovies(listener);
    }

    public void getPopularMovieList(MoviesDataSource.OnFetchMovieListener listener) {
        mGenresDataSource.getPopular(listener);
    }

    public void getTopRatedMovieList(MoviesDataSource.OnFetchMovieListener listener) {
        mGenresDataSource.getTopRatedMovieDataSource(listener);
    }

    public void getUpComingMovie(MoviesDataSource.OnFetchMovieListener listener) {
        mGenresDataSource.getUpcoming(listener);
    }
}
