package com.example.project_movie_01.data.source.nowplayingmovie;

import com.example.project_movie_01.data.MoviesMovieDataSource;
import com.example.project_movie_01.utils.StringUtils;

public class NowPlayingMovieDataSource implements MoviesMovieDataSource.FetchMovieDataSource {
    private static NowPlayingMovieDataSource sInstance;

    public NowPlayingMovieDataSource() {
    }

    public static NowPlayingMovieDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new NowPlayingMovieDataSource();
        }
        return sInstance;
    }

    @Override
    public void getMovies(MoviesMovieDataSource.OnFetchMovieListener listener) {
        FetchNowPlayingMovieFromUrl fetchNowPlayingMovieFromUrl = new FetchNowPlayingMovieFromUrl(listener);
        fetchNowPlayingMovieFromUrl.execute(StringUtils.getAPINowPlayingMovie());
    }
}
