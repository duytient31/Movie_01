package com.example.project_movie_01.screen.home.genres.nowplaying;

import com.example.project_movie_01.data.model.Genres;

import java.util.List;

public interface NowPlayingMovieContract {
    interface view {
        void onNowPlayingMovieSucces(List<Genres> nowPlayings);

        void onNowPlayingMovieFailure(String message);
    }

    interface presenter {
        void getNowPlayingMovie();
    }
}
