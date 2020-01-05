package com.example.project_movie_01.data.source.nowplayingmovie;

import android.os.AsyncTask;

import com.example.project_movie_01.constant.Constant;
import com.example.project_movie_01.constant.PopularMovieEntity;
import com.example.project_movie_01.data.MoviesMovieDataSource;
import com.example.project_movie_01.data.model.NowPlayingMovie;

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

public class FetchNowPlayingMovieFromUrl extends AsyncTask<String, Void, List<NowPlayingMovie>> {
    private MoviesMovieDataSource.OnFetchMovieListener<NowPlayingMovie> mListener;
    private Exception mException;

    public FetchNowPlayingMovieFromUrl(MoviesMovieDataSource.OnFetchMovieListener<NowPlayingMovie> listener) {
        mListener = listener;
    }

    @Override
    protected List<NowPlayingMovie> doInBackground(String... strings) {
        String url = strings[0];

        try {
            String data = getStringDataFromUrl(url);
            return getDataFromStringData(data);
        } catch (IOException | JSONException e) {
            mException = e;
        }
        return null;
    }

    private List<NowPlayingMovie> getDataFromStringData(String data) throws JSONException {
        List<NowPlayingMovie> nowPlayings = new ArrayList<>();
        JSONObject object = new JSONObject(data);
        JSONArray jsonArray = object.getJSONArray(PopularMovieEntity.RESULTS);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String popularity = jsonObject.getString(PopularMovieEntity.POPULARITY);
            String vote_count = jsonObject.getString(PopularMovieEntity.VOTE_COUNT);
            String poster_path = jsonObject.getString(PopularMovieEntity.POSTER_PATH);
            String id = jsonObject.getString(PopularMovieEntity.ID);
            String title = jsonObject.getString(PopularMovieEntity.TITLE);
            String voteAverage = jsonObject.getString(PopularMovieEntity.VOTE_AVERAGE);
            String overview = jsonObject.getString(PopularMovieEntity.OVERVIEW);
            String release_date = jsonObject.getString(PopularMovieEntity.RELEASE_DATE);
            NowPlayingMovie nowPlaying = new NowPlayingMovie(popularity, vote_count, poster_path, id
                    , title, voteAverage, overview, release_date);
            nowPlayings.add(nowPlaying);
        }
        return nowPlayings;
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
    protected void onPostExecute(List<NowPlayingMovie> nowPlayings) {
        if (mListener == null) {
            return;
        }
        if (mException == null) {
            mListener.onFetchMovieSuccess(nowPlayings);
        } else {
            mListener.onFetchMovieFailure(mException);
        }
    }
}
