package com.example.project_movie_01.data.source;

import com.example.project_movie_01.data.MoviesDataSource;
import com.example.project_movie_01.utils.StringUtils;

public class GenresDataSource {
    private static GenresDataSource sInstance;

    private GenresDataSource() {
    }

    public static GenresDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new GenresDataSource();
        }
        return sInstance;
    }

    public void getMovies(MoviesDataSource.OnFetchMovieListener listener) {
        FetchGenresFromUrl fetchGenresFromUrl = new FetchGenresFromUrl(listener);
        fetchGenresFromUrl.execute(StringUtils.getAPINowPlayingMovie());
    }

    public void getPopular(MoviesDataSource.OnFetchMovieListener listener) {
        FetchGenresFromUrl fetchGenresFromUrl = new FetchGenresFromUrl(listener);
        fetchGenresFromUrl.execute(StringUtils.getAPIPopularMovie());
    }

    public void getTopRatedMovieDataSource(MoviesDataSource.OnFetchMovieListener listener) {
        FetchGenresFromUrl fetchGenresFromUrl = new FetchGenresFromUrl(listener);
        fetchGenresFromUrl.execute(StringUtils.getAPITopRateMovie());
    }

    public void getUpcoming(MoviesDataSource.OnFetchMovieListener listener) {
        FetchGenresFromUrl fetchGenresFromUrl = new FetchGenresFromUrl(listener);
        fetchGenresFromUrl.execute(StringUtils.getAPIUpComingMovie());
    }
}
