package com.example.project_movie_01.constant;

import androidx.annotation.StringDef;

@StringDef({PopularMovieEntity.RESULTS, PopularMovieEntity.POPULARITY, PopularMovieEntity.VOTE_COUNT,
        PopularMovieEntity.POSTER_PATH, PopularMovieEntity.ID, PopularMovieEntity.TITLE,
        PopularMovieEntity.VOTE_AVERAGE, PopularMovieEntity.OVERVIEW, PopularMovieEntity.RELEASE_DATE})
public @interface PopularMovieEntity {
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
