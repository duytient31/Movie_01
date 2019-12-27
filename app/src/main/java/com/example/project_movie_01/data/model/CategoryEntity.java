package com.example.project_movie_01.data.model;

import androidx.annotation.StringDef;

@StringDef({CategoryEntity.CATEGORY_NOW_PLAYING, CategoryEntity.CATEGORY_POPULAR,
        CategoryEntity.CATEGOTY_TOP_RATED, CategoryEntity.CATEGORY_UPCOMMING})
public @interface CategoryEntity {
    String CATEGORY_POPULAR = "popular";
    String CATEGORY_NOW_PLAYING = "now_playing";
    String CATEGOTY_TOP_RATED = "top_rated";
    String CATEGORY_UPCOMMING = "up_comming";
}
