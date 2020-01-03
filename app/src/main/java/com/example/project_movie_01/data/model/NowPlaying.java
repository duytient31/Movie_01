package com.example.project_movie_01.data.model;

public class NowPlaying {
    private String mPopularity;
    private String mVoteCount;
    private String mPosterPath;
    private String mId;
    private String mTitle;
    private String mVoteAverage;
    private String mOverview;
    private String mReleaseDate;

    public NowPlaying() {
    }

    public NowPlaying(String popularity, String voteCount,
                      String posterPath, String id, String title, String voteAverage, String overview, String releaseDate) {
        mPopularity = popularity;
        mVoteCount = voteCount;
        mPosterPath = posterPath;
        mId = id;
        mTitle = title;
        mVoteAverage = voteAverage;
        mOverview = overview;
        mReleaseDate = releaseDate;
    }

    public String getPopularity() {
        return mPopularity;
    }

    public void setPopularity(String popularity) {
        mPopularity = popularity;
    }

    public String getVoteCount() {
        return mVoteCount;
    }

    public void setVoteCount(String voteCount) {
        mVoteCount = voteCount;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        mVoteAverage = voteAverage;
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

