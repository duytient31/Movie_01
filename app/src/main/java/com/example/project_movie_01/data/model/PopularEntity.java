package com.example.project_movie_01.data.model;

import androidx.annotation.StringDef;

@StringDef({PopularEntity.RESULTS, PopularEntity.POPULARITY,
        PopularEntity.RELEASE_DATE, PopularEntity.TITLE,
        PopularEntity.POSTER_PATH, PopularEntity.OVERVIEW, PopularEntity.VOTE_AVERAGE})
public @interface PopularEntity {
    String RESULTS = "results";
    String POPULARITY = "popularity";
    String POSTER_PATH = "poster_path";
    String VOTE_AVERAGE = "vote_average";
    String TITLE = "title";
    String OVERVIEW = "overview";
    String RELEASE_DATE = "release_date";
}
