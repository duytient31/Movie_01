package com.example.project_movie_01.data.model;

import androidx.annotation.StringDef;

@StringDef({
        MovieEntity.ID,
        MovieEntity.NAME,
        MovieEntity.BACKDROP_PATH,
        MovieEntity.GENRES,
        MovieEntity.OVERVIEW,
        MovieEntity.PRODUCTION_COMPANIES,
        MovieEntity.RELEASE_DATE,
        MovieEntity.RUNTIME,
        MovieEntity.VIDEO,
        MovieEntity.VOTE_AVERAGE})
public @interface MovieEntity {
    String ID = "id";
    String NAME = "name";
    String BACKDROP_PATH = "backdrop_path";
    String GENRES = "genres";
    String OVERVIEW = "overview";
    String PRODUCTION_COMPANIES = "production_companies";
    String RELEASE_DATE = "release_date";
    String RUNTIME = "runtime";
    String VIDEO = "video";
    String VOTE_AVERAGE = "vote_average";


}
