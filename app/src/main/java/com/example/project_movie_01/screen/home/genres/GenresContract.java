package com.example.project_movie_01.screen.home.genres;

import com.example.project_movie_01.data.model.Genres;

import java.util.List;

public interface GenresContract {
    interface view {
        void onGenresSuccess(List<Genres> genres);

        void onGenresFailure(String message);
    }

    interface presenter {
        void getNowPlayingMovie();
        void getTopRatedMovie();
        void getPopularMovie();
        void getUpComingMovie();
    }
}
