package com.troopes.android.data.model;

public class Wishlist {
    public long productId;
    public String productName;
    public int productCost; // discountedPrice
    public int originalCost;
    public int discountedPercent;
    public String productUrl = null;
    public String productImageUrl = null;

    public Wishlist(long productId, String productName, int productCost, int originalCost, int discountedPercent, String productUrl, String productImageUrl) {
        this.productId = productId;
        this.productName = productName;
        this.productCost = productCost;
        this.originalCost = originalCost;
        this.discountedPercent = discountedPercent;
        this.productUrl = productUrl;
        this.productImageUrl = productImageUrl;
    }
}
