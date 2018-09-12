package com.troopes.android.data.model;

import java.util.List;

public class Review {
    public String profileName;
    public String profileImageUrl;
    public String reviewDate;
    public float rating;
    public String productVariant;
    public String productSize;
    public String productColor;
    public List<String> reviewImagesUrl;
    public String review;

    public Review(String profileName, String reviewDate, float rating, String productVariant, String productSize, String productColor, String review, List<String> reviewImagesUrl) {
        this.profileName = profileName;
        this.reviewDate = reviewDate;
        this.rating = rating;
        this.productVariant = productVariant;
        this.productSize = productSize;
        this.productColor = productColor;
        this.review = review;
        this.reviewImagesUrl = reviewImagesUrl;
    }

}