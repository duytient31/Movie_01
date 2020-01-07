package com.example.project_movie_01.data.source;

import android.os.AsyncTask;

import com.example.project_movie_01.constant.Constant;
import com.example.project_movie_01.data.MoviesDataSource;
import com.example.project_movie_01.data.model.Genres;
import com.example.project_movie_01.utils.ParseMovieFromJson;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class FetchGenresFromUrl extends AsyncTask<String, Void, List<Genres>> {
    private MoviesDataSource.OnFetchMovieListener<Genres> mListener;
    private Exception mException;

    public FetchGenresFromUrl(MoviesDataSource.OnFetchMovieListener<Genres> listener) {
        mListener = listener;
    }

    @Override
    protected List<Genres> doInBackground(String... strings) {
        String url = strings[0];
        try {
            String data = getStringDataFromUrl(url);
            ParseMovieFromJson parseMovieFromJson = new ParseMovieFromJson(data);
            return parseMovieFromJson.getGenresMovieFromStringData();
        } catch (IOException | JSONException e) {
            mException = e;
        }
        return null;
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
    protected void onPostExecute(List<Genres> nowPlayings) {
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
