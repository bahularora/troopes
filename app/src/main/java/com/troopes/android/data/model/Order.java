package com.troopes.android.data.model;

import com.troopes.android.data.constants.ORDER_STATUS;

public class Order {
    public long orderId;
    public long productId;
    public String orderDate;
    public ORDER_STATUS orderStatus;

    public Order(long orderId, long productId, String orderDate, ORDER_STATUS orderStatus) {
        this.orderId = orderId;
        this.productId = productId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

}
