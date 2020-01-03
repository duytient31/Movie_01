package com.example.project_movie_01.constant;

import com.example.project_movie_01.BuildConfig;

public class Constant {
    public static final String REQUEST_METHOD_GET = "GET";
    public static final int CONENECT_TIME_OUT = 5000;
    public static final int READ_TIME_OUT = 5000;
    public static final String BREAK_LINE = "\n";
    public String API_KEY = BuildConfig.API_KEY;
    public static final String URL_POPULAR = "movie/popular?api_key=";
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
}
