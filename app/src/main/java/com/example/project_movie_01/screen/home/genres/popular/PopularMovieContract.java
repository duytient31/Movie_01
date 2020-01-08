package com.example.project_movie_01.screen.home.genres.popular;

import com.example.project_movie_01.data.model.Genres;

import java.util.List;

public interface PopularMovieContract {
    interface View {
        void onGetPopularMovieSucces(List<Genres> populars);

        void onGetPoplarMovieFailure(String message);
    }

    interface Presenter {
        void getPopularMovie();
    }
}
