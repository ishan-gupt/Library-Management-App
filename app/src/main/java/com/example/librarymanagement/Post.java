package com.example.librarymanagement;

import com.google.gson.annotations.SerializedName;

class Post {
    private int userid;
    private int id;
    private String title;

    @SerializedName("body")
    private String text;

    int getUserid() {
        return userid;
    }

     int getId() {
        return id;
    }

     String getTitle() {
        return title;
    }

     String getText() {
        return text;
    }
}
