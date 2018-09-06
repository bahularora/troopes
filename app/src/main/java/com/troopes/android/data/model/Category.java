package com.troopes.android.data.model;

import java.util.ArrayList;

public class Category {

    private String name;
    private String imageUrl;
    private String url;
    private ArrayList<SubCategory> subCategories;

    public Category(String name, String imageUrl, ArrayList<SubCategory> subCategories) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.subCategories = subCategories;
    }

    public ArrayList<SubCategory> getSubCategories() {
        return subCategories;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }
}
