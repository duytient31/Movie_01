package com.example.project_movie_01.utils;

import com.example.project_movie_01.BuildConfig;
import com.example.project_movie_01.constant.Constant;

public class StringUtils {
    public static String getAPIPopularMovie() {
        return String.format("%s%s%s", Constant.BASE_URL_MOVIE, Constant.URL_POPULAR_MOVIE, BuildConfig.API_KEY);
    }

    public static String getAPINowPlayingMovie() {
        return String.format("%s%s%s", Constant.BASE_URL_MOVIE, Constant.URL_NOW_PLAYING_MOVIE, BuildConfig.API_KEY);
    }

    public static String formatFromBaseURL(String baseImageUrl, String path) {
        return String.format("%s/%s", Constant.BASE_IMAGE_URL, path);
    }

}
