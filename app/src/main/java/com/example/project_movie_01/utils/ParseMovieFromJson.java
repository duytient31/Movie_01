package com.example.project_movie_01.utils;

import com.example.project_movie_01.constant.MovieEntity;
import com.example.project_movie_01.data.model.Genres;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParseMovieFromJson {
    private String mJson;

    public ParseMovieFromJson(String json) {
        mJson = json;
    }

    public List<Genres> getGenresMovieFromStringData() throws JSONException {
        List<Genres> nowPlayings = new ArrayList<>();
        JSONObject object = new JSONObject(mJson);
        JSONArray jsonArray = object.getJSONArray(MovieEntity.RESULTS);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String popularity = jsonObject.getString(MovieEntity.POPULARITY);
            String votecount = jsonObject.getString(MovieEntity.VOTE_COUNT);
            String posterpath = jsonObject.getString(MovieEntity.POSTER_PATH);
            String id = jsonObject.getString(MovieEntity.ID);
            String title = jsonObject.getString(MovieEntity.TITLE);
            String voteaverage = jsonObject.getString(MovieEntity.VOTE_AVERAGE);
            String overview = jsonObject.getString(MovieEntity.OVERVIEW);
            String releasedate = jsonObject.getString(MovieEntity.RELEASE_DATE);
            Genres nowPlaying = new Genres(popularity, votecount, posterpath, id
                    , title, voteaverage, overview, releasedate);
            nowPlayings.add(nowPlaying);
        }
        return nowPlayings;
    }
}
