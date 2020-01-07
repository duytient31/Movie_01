package com.example.project_movie_01.data.source;

import com.example.project_movie_01.data.MoviesDataSource;
import com.example.project_movie_01.utils.StringUtils;

public class GenresDataSource implements MoviesDataSource.FetchMovieDataSource,
        MoviesDataSource.FetchPopularDataSource {
    private static GenresDataSource sInstance;

    private GenresDataSource() {
    }

    public static GenresDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new GenresDataSource();
        }
        return sInstance;
    }

    @Override
    public void getMovies(MoviesDataSource.OnFetchMovieListener listener) {
        FetchGenresFromUrl fetchGenresFromUrl = new FetchGenresFromUrl(listener);
        fetchGenresFromUrl.execute(StringUtils.getAPINowPlayingMovie());
    }

    @Override
    public void getPopular(MoviesDataSource.OnFetchMovieListener listener) {
        FetchGenresFromUrl fetchGenresFromUrl = new FetchGenresFromUrl(listener);
        fetchGenresFromUrl.execute(StringUtils.getAPIPopularMovie());
    }
}
