package com.troopes.android.ui.account.myOrders;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.troopes.android.R;
import com.troopes.android.common.BaseViewHolder;
import com.troopes.android.data.constants.ORDER_STATUS;
import com.troopes.android.data.model.Order;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderHolder extends BaseViewHolder {

    @BindView(R.id.product_image)
    ImageView productImage;
    @BindView(R.id.product_name)
    TextView productName;
    @BindView(R.id.discount_percent)
    TextView discountPercent;
    @BindView(R.id.product_discounted_price)
    TextView productDiscountedPrice; // or product cost
    @BindView(R.id.product_original_price)
    TextView productOriginalPrice;
    @BindView(R.id.order_status)
    TextView orderStatus;
    @BindView(R.id.other_buyer_icon)
    ImageView otherBuyerIcon;
    @BindView(R.id.other_buyer_text)
    TextView otherBuyerText;
    @BindView(R.id.delivery_date)
    TextView deliveryDate;

    public OrderHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(Order order) {
        Picasso.get().load(order.productImageUrl).fit().centerCrop().into(productImage);
        productName.setText(order.productName);
        productDiscountedPrice.setText("Rs " + String.valueOf(order.productCost));
        productOriginalPrice.setText("Rs " + String.valueOf(order.originalCost));
        productOriginalPrice.setPaintFlags(productOriginalPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        discountPercent.setText(String.valueOf(order.discountedPercent) + "%");

        if (order.orderStatus == ORDER_STATUS.DELIVERED) {
            deliveryDate.setText("(Delivered on " + order.orderDate + ")");
            orderStatus.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.deliveredOrder));
            orderStatus.setText("Delivered");
        } else if (order.orderStatus == ORDER_STATUS.PENDING) {
            deliveryDate.setText("(Ordered on " + order.orderDate + ")");
            orderStatus.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.pendingOrder));
            orderStatus.setText("Pending");
        } else if (order.orderStatus == ORDER_STATUS.CANCELLED) {
            deliveryDate.setText("(Cancelled on " + order.orderDate + ")");
            orderStatus.setText("Cancelled");
            orderStatus.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.cancelledOrder));
        } else if (order.orderStatus == ORDER_STATUS.IN_PROCESS) {
            deliveryDate.setText("(Arriving on " + order.orderDate + ")");
            orderStatus.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.inProcessOrder));
            orderStatus.setText("In Process");
        }

    }
}
