package com.example.project_movie_01.data.model;

public class Movies {
    private String mId;
    private String mName;
    private String mBackdropPath;
    private String mGenres;
    private String mOverView;
    private String mProductionCompanies;
    private String mReleaseDate;
    private String mRunTime;
    private String mVideo;
    private String mVoteAverage;

    public Movies() {
    }

    public Movies(String id, String name, String backdropPath, String genres,
                  String overView, String productionCompanies, String releaseDate,
                  String runTime, String video, String voteAverage) {
        mId = id;
        mName = name;
        mBackdropPath = backdropPath;
        mGenres = genres;
        mOverView = overView;
        mProductionCompanies = productionCompanies;
        mReleaseDate = releaseDate;
        mRunTime = runTime;
        mVideo = video;
        mVoteAverage = voteAverage;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        mBackdropPath = backdropPath;
    }

    public String getGenres() {
        return mGenres;
    }

    public void setGenres(String genres) {
        mGenres = genres;
    }

    public String getOverView() {
        return mOverView;
    }

    public void setOverView(String overView) {
        mOverView = overView;
    }

    public String getProductionCompanies() {
        return mProductionCompanies;
    }

    public void setProductionCompanies(String productionCompanies) {
        mProductionCompanies = productionCompanies;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    public String getRunTime() {
        return mRunTime;
    }

    public void setRunTime(String runTime) {
        mRunTime = runTime;
    }

    public String getVideo() {
        return mVideo;
    }

    public void setVideo(String video) {
        mVideo = video;
    }

    public String getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        mVoteAverage = voteAverage;
    }
}


