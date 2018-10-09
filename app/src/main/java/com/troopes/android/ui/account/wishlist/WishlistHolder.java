package com.troopes.android.ui.account.wishlist;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.troopes.android.R;
import com.troopes.android.common.BaseViewHolder;
import com.troopes.android.data.model.Wishlist;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WishlistHolder extends BaseViewHolder {

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

    public WishlistHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(Wishlist wishlist) {
        Picasso.get().load(wishlist.productImageUrl).fit().centerCrop().into(productImage);
        productName.setText(wishlist.productName);
        productDiscountedPrice.setText("Rs" + String.valueOf(wishlist.productCost));
        productOriginalPrice.setText("Rs" + String.valueOf(wishlist.originalCost));
        productOriginalPrice.setPaintFlags(productOriginalPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        discountPercent.setText(String.valueOf(wishlist.discountedPercent) + "%");
    }
}
