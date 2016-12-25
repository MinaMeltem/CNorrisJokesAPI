package com.example.c4q.chucknorrisjokes.model;

/**
 * Created by C4Q on 12/25/16.
 */

public class Jokes {

    private String iconurl;
    private String id;
    private String url;
    private String value;


    public Jokes(String iconurl, String id, String url, String value) {
        this.iconurl = iconurl;
        this.id = id;
        this.url = url;
        this.value = value;
    }

    public String getIconurl() {
        return iconurl;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getValue() {
        return value;
    }
}
