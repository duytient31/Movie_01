package com.example.project_movie_01.constant;

import androidx.annotation.StringDef;

@StringDef({MovieEntity.RESULTS, MovieEntity.POPULARITY, MovieEntity.VOTE_COUNT,
        MovieEntity.POSTER_PATH, MovieEntity.ID, MovieEntity.TITLE,
        MovieEntity.VOTE_AVERAGE, MovieEntity.OVERVIEW, MovieEntity.RELEASE_DATE})
public @interface MovieEntity {
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
