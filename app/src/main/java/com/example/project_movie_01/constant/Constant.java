package com.example.project_movie_01.constant;

import com.example.project_movie_01.BuildConfig;

public class Constant {
    public static final String REQUEST_METHOD_GET = "GET";
    public static final int CONENECT_TIME_OUT = 5000;
    public static final int READ_TIME_OUT = 5000;
    public static final String BREAK_LINE = "\n";
    public String API_KEY = BuildConfig.API_KEY;
    public static final String URL_POPULAR_MOVIE = "movie/popular?api_key=";
    public static final String URL_NOW_PLAYING_MOVIE = "movie/now_playing?api_key=";
    public static final String URL_TOP_RATED_MOVIE = "movie/top_rated?api_key=";
    public static final String URL_UPCOMING_MOVIE = "movie/upcoming?api_key=";
    public static final String BASE_URL_MOVIE = "https://api.themoviedb.org/3/";
    public static final String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w300";
}
