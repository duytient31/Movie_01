package com.example.project_movie_01.constant;

import androidx.annotation.StringDef;

@StringDef({NowPlayingMovieEntity.RESULTS, NowPlayingMovieEntity.POPULARITY, NowPlayingMovieEntity.VOTE_COUNT,
        NowPlayingMovieEntity.POSTER_PATH, NowPlayingMovieEntity.ID, NowPlayingMovieEntity.TITLE,
        NowPlayingMovieEntity.VOTE_AVERAGE, NowPlayingMovieEntity.OVERVIEW, NowPlayingMovieEntity.RELEASE_DATE})
public @interface NowPlayingMovieEntity {
    String RESULTS = "results";
    String POPULARITY = "popularity";
    String VOTE_COUNT = "vote_count";
    String POSTER_PATH = "poster_path";
    String ID = "id";
    String TITLE = "title";
    String VOTE_AVERAGE = "vote_average";
    String OVERVIEW = "overview";
    String RELEASE_DATE = "release_date";
}
