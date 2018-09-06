package com.troopes.android.data.model;

public class SubCategory {

    String name;
    String imageUrl;
    String url;

    public SubCategory(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
