package com.example.project_movie_01.constant;

import androidx.annotation.StringDef;

@StringDef({PopularEntity.RESULTS, PopularEntity.POPULARITY, PopularEntity.VOTE_COUNT,
        PopularEntity.POSTER_PATH, PopularEntity.ID, PopularEntity.TITLE,
        PopularEntity.VOTE_AVERAGE, PopularEntity.OVERVIEW, PopularEntity.RELEASE_DATE})
public @interface PopularEntity {
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
