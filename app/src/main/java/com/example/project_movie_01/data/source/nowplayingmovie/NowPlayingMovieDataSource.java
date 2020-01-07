package com.example.project_movie_01.data.source.nowplayingmovie;

import com.example.project_movie_01.data.MoviesDataSource;
import com.example.project_movie_01.utils.StringUtils;

public class NowPlayingMovieDataSource implements MoviesDataSource.FetchMovieDataSource {
    private static NowPlayingMovieDataSource sInstance;

    private NowPlayingMovieDataSource() {
    }

    public static NowPlayingMovieDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new NowPlayingMovieDataSource();
        }
        return sInstance;
    }

    @Override
    public void getMovies(MoviesDataSource.OnFetchMovieListener listener) {
        FetchNowPlayingMovieFromUrl fetchNowPlayingMovieFromUrl = new FetchNowPlayingMovieFromUrl(listener);
        fetchNowPlayingMovieFromUrl.execute(StringUtils.getAPINowPlayingMovie());
    }
}
