package com.example.project_movie_01.data.source;

import android.os.AsyncTask;

import com.example.project_movie_01.constant.Constant;
import com.example.project_movie_01.constant.PopularEntity;
import com.example.project_movie_01.data.MovieDataSource;
import com.example.project_movie_01.data.model.Popular;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FetchPopularFromUrl extends AsyncTask<String, Void, List<Popular>> {
    private MovieDataSource.OnFetchDataListener<Popular> mListener;
    private Exception mException;

    public void setListener(MovieDataSource.OnFetchDataListener<Popular> listener) {
        mListener = listener;
    }

    @Override
    protected List<Popular> doInBackground(String... strings) {
        String url = strings[0];
        try {
            String data = getStringDataFromUrl(url);
            return getPopularFromStringData(data);
        } catch (IOException | JSONException e) {
            mException = e;
        }
        return null;
    }

    private List<Popular> getPopularFromStringData(String data) throws JSONException {
        List<Popular> populars = new ArrayList<>();
        JSONObject object = new JSONObject(data);
        JSONArray jsonArray = object.getJSONArray(PopularEntity.RESULTS);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String popularity = jsonObject.getString(PopularEntity.POPULARITY);
            String vote_count = jsonObject.getString(PopularEntity.VOTE_COUNT);
            String poster_path = jsonObject.getString(PopularEntity.POSTER_PATH);
            String id = jsonObject.getString(PopularEntity.ID);
            String title = jsonObject.getString(PopularEntity.TITLE);
            String vote_average = jsonObject.getString(PopularEntity.VOTE_AVERAGE);
            String overview = jsonObject.getString(PopularEntity.OVERVIEW);
            String release_date = jsonObject.getString(PopularEntity.RELEASE_DATE);
            Popular popular = new Popular(popularity, vote_count, poster_path, id
                    , title, vote_average, overview, release_date);
            populars.add(popular);
        }
        return populars;
    }

    private String getStringDataFromUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(Constant.REQUEST_METHOD_GET);
        connection.setConnectTimeout(Constant.CONENECT_TIME_OUT);
        connection.setReadTimeout(Constant.READ_TIME_OUT);
        connection.setDoOutput(true);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append(Constant.BREAK_LINE);
        }
        br.close();
        connection.disconnect();
        return sb.toString();
    }

    @Override
    protected void onPostExecute(List<Popular> populars) {
        if (mListener == null) {
            return;
        }
        if (mException == null) {
            mListener.onFetchDataSuccess(populars);
        } else {
            mListener.onFetchDataFailure(mException);
        }
    }
}
