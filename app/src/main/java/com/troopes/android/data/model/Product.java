package com.troopes.android.data.model;

public class Product {
    public Product(String name, int cost, long itemsSold) {
        this.name = name;
        this.cost = cost;
        this.itemsSold = itemsSold;
    }

    public String name;
    // don't want product to cost money in denomination smaller than 1 rs
    public int cost;
    public long itemsSold;

    // TODO
    public String productUrl = null;
    public String imageUrl = null;
}
