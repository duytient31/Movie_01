package com.example.project_movie_01.data;

import java.util.List;

public interface MovieDataSource {
    interface OnFetchDataListener<T>{
        void onFetchDataSuccess(List<T> data);

        void onFetchDataFailure(Exception e);
    }
}
