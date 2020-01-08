package com.example.project_movie_01.screen.home.genres.upcoming;

import com.example.project_movie_01.data.model.Genres;

import java.util.List;

public interface UpComingContract {
    interface view {
        void onGetUpComingMovieSuccess(List<Genres> genres);

        void onGetUpComingMovieFailure(String message);
    }

    interface presenter {
        void getUpComingMovie();
    }
}
