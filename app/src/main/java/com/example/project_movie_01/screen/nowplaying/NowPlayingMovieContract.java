package com.example.project_movie_01.screen.nowplaying;

import com.example.project_movie_01.data.model.NowPlayingMovie;

import java.util.List;

public interface NowPlayingMovieContract {
    interface view {
        void onNowPlayingSucces(List<NowPlayingMovie> nowPlayings);

        void onNowPlayingFailure(String message);
    }

    interface presenter {
        void getNowPlayings();
    }
}
