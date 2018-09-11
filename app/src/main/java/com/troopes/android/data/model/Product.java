package com.troopes.android.data.model;

public class Product {
    public long productId;

    public Product(long productId, String name, int cost, long itemsSold, String imageUrl) {
        this.name = name;
        this.cost = cost;
        this.itemsSold = itemsSold;
        this.imageUrl = imageUrl;
        this.productId = productId;
    }
    public String name;
    // don't want product to cost money in denomination smaller than 1 rs
    public int cost;
    public long itemsSold;
    public String productUrl = null;
    public String imageUrl = null;
}
