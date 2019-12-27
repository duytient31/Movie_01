package com.example.project_movie_01.data.source;

import android.os.AsyncTask;

import com.example.project_movie_01.data.MovieDataSource;
import com.example.project_movie_01.data.model.Popular;
import com.example.project_movie_01.data.model.PopularEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class FetchMovieFromUrle extends AsyncTask<String, Void, List<Popular>> {
    private MovieDataSource.OnFetchDataListener<Popular> mListener;
    private Exception mException;

    public void setListener(MovieDataSource.OnFetchDataListener<Popular> listener) {
        mListener = listener;
    }

    @Override
    protected List<Popular> doInBackground(String... strings) {
        String url = strings[0];

        String data = getStringDataFromUrl(url);
        try {
            return getPopularFromStringData(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Popular> getPopularFromStringData(String data) throws JSONException {

        List<Popular> populars = new ArrayList<>();
        JSONObject object = new JSONObject(data);
        JSONArray jsonArray = new JSONArray(PopularEntity.RESULTS);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonPopular = (JSONObject) jsonArray.get(i);
            String popularity = jsonPopular.getString(PopularEntity.POPULARITY);
            String posterPath = jsonPopular.getString(PopularEntity.POSTER_PATH);
            String voteAverage = jsonPopular.getString(PopularEntity.VOTE_AVERAGE);
            String title = jsonPopular.getString(PopularEntity.TITLE);
            String overview = jsonPopular.getString(PopularEntity.OVERVIEW);
            String releaseDate = jsonPopular.getString(PopularEntity.RELEASE_DATE);

            Popular popular = new Popular(popularity, posterPath, voteAverage, title, overview, releaseDate);
            populars.add(popular);

        }
        return populars;
    }

    private String getStringDataFromUrl(String urlString) {
        try {
            URL url =new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
