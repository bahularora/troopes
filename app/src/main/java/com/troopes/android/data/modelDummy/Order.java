package com.troopes.android.data.modelDummy;

import com.troopes.android.data.constants.ORDER_STATUS;

public class Order {
    public long orderId;
    public long productId;
    public String productName;
    public int productCost; // discountedPrice
    public int originalCost;
    public int discountedPercent;
    public String productUrl = null;
    public String productImageUrl = null;
    public String orderDate; // for now it will work as delivery date, ordered date, cancelled date
    public ORDER_STATUS orderStatus;

    public Order(long orderId, long productId, String orderDate, ORDER_STATUS orderStatus, String productName, int productCost, int originalCost, int discountedPercent, String productUrl, String productImageUrl) {
        this.orderId = orderId;
        this.productId = productId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.productName = productName;
        this.productCost = productCost;
        this.originalCost = originalCost;
        this.discountedPercent = discountedPercent;
        this.productUrl = productUrl;
        this.productImageUrl = productImageUrl;
    }

}
