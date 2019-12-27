package com.example.project_movie_01.data.model;

import androidx.annotation.StringDef;

@StringDef({GenresEntity.ID, GenresEntity.NAME})
public @interface GenresEntity {
    String ID = "id";
    String NAME = "NAME";
}
