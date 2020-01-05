package com.example.project_movie_01.data.repository;

import com.example.project_movie_01.data.MoviesMovieDataSource;
import com.example.project_movie_01.data.source.nowplayingmovie.NowPlayingMovieDataSource;

public class NowPlayingMovieReponsitory {
    private static NowPlayingMovieReponsitory sInstance;
    private NowPlayingMovieDataSource mNowPlayingMovieDataSource;

    public NowPlayingMovieReponsitory(NowPlayingMovieDataSource nowPlayingMovieDataSource) {
        mNowPlayingMovieDataSource = nowPlayingMovieDataSource;
    }
    public static NowPlayingMovieReponsitory getInstance(){
        if (sInstance == null){
            sInstance = new NowPlayingMovieReponsitory(NowPlayingMovieDataSource.getInstance());
        }
        return sInstance;
    }
    public void getNowPlayingMovieList(MoviesMovieDataSource.OnFetchMovieListener listener){
        mNowPlayingMovieDataSource.getMovies(listener);
    }
}
