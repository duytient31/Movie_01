package com.example.project_movie_01.constant;

import androidx.annotation.StringDef;

@StringDef({NowPlayingEntity.RESULTS, NowPlayingEntity.POPULARITY, NowPlayingEntity.VOTE_COUNT,
        NowPlayingEntity.POSTER_PATH, NowPlayingEntity.ID, NowPlayingEntity.TITLE,
        NowPlayingEntity.VOTE_AVERAGE, NowPlayingEntity.OVERVIEW, NowPlayingEntity.RELEASE_DATE})
public @interface NowPlayingEntity {
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
