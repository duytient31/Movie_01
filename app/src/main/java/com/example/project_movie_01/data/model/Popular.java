package com.example.project_movie_01.data.model;

public class Popular {
    private String mPopularity;
    private String mPosterPath;
    private String mVoteAverage;
    private String mTitle;
    private String mOverview;
    private String mReleaseDate;

    public Popular() {
    }

    public Popular(String popularity, String posterPath
            , String voteAverage, String title, String overview, String releaseDate) {
        mPopularity = popularity;
        mPosterPath = posterPath;
        mVoteAverage = voteAverage;
        mTitle = title;
        mOverview = overview;
        mReleaseDate = releaseDate;
    }

    public String getPopularity() {
        return mPopularity;
    }

    public void setPopularity(String popularity) {
        mPopularity = popularity;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    public String getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        mVoteAverage = voteAverage;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }
}
