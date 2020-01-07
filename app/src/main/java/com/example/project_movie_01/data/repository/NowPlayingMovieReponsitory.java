package com.example.project_movie_01.data.repository;

import com.example.project_movie_01.data.MoviesDataSource;
import com.example.project_movie_01.data.source.nowplayingmovie.NowPlayingMovieDataSource;

public class NowPlayingMovieReponsitory {
    private static NowPlayingMovieReponsitory sInstance;
    private NowPlayingMovieDataSource mNowPlayingMovieDataSource;

    private NowPlayingMovieReponsitory(NowPlayingMovieDataSource nowPlayingMovieDataSource) {
        mNowPlayingMovieDataSource = nowPlayingMovieDataSource;
    }

    public static NowPlayingMovieReponsitory getInstance() {
        if (sInstance == null) {
            sInstance = new NowPlayingMovieReponsitory(NowPlayingMovieDataSource.getInstance());
        }
        return sInstance;
    }

    public void getNowPlayingMovieList(MoviesDataSource.OnFetchMovieListener listener) {
        mNowPlayingMovieDataSource.getMovies(listener);
    }
}
