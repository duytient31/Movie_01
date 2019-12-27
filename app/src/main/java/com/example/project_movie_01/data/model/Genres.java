package com.example.project_movie_01.data.model;

public class Genres {

    private String mName;
    private int mId;

    public Genres() {
    }

    public Genres(String name, int id) {
        mName = name;
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }
}

