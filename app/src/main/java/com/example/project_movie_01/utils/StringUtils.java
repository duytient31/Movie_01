package com.example.project_movie_01.utils;

import com.example.project_movie_01.BuildConfig;
import com.example.project_movie_01.constant.Constant;

public class StringUtils {
    public static String getAPI() {
        return String.format("%s%s%s", Constant.BASE_URL, Constant.URL_POPULAR, BuildConfig.API_KEY);
    }
}