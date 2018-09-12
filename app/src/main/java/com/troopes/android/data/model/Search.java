package com.troopes.android.data.model;

import java.util.List;

public class Search {
    public String name;
    // position
    public String url;
    public List<SubCategory> list;

    public Search(String name, String url, List<SubCategory> list) {
        this.name = name;
        this.url = url;
        this.list = list;
    }
}