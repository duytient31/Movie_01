package com.example.project_movie_01.screen.home.genres.toprated;

import com.example.project_movie_01.data.model.Genres;

import java.util.List;

public interface TopRatedMovieContract {
    interface view {
        void onGetTopRatedMovieSuccess(List<Genres> genres);

        void onGetTopRatedMovieFailure(String message);
    }

    interface presenter {
        void getTopRatedMovie();
    }
}
