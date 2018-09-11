package com.troopes.android.data.model.product;

import java.util.ArrayList;

public class Product {
    public long productId;
    public ArrayList<Color> colorList;
    public String name;
    // don't want product to cost money in denomination smaller than 1 rs
    public int cost;
    public long itemsSold;
    public String productUrl = null;
    public String imageUrl = null;
    public ArrayList<Size> sizeList;
    public ArrayList<Variant> variantList;
    public ArrayList<String> productImagesUrl;

    public Product(long productId, String name, int cost, long itemsSold, String imageUrl, ArrayList<Color> colorList, ArrayList<Size> sizeList, ArrayList<Variant> variantList, ArrayList<String> productImagesUrl) {
        this.name = name;
        this.cost = cost;
        this.itemsSold = itemsSold;
        this.imageUrl = imageUrl;
        this.productId = productId;
        this.colorList = colorList;
        this.sizeList = sizeList;
        this.variantList = variantList;
        this.productImagesUrl = productImagesUrl;
    }
}
