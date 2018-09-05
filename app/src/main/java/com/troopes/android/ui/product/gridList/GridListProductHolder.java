package com.troopes.android.ui.product.gridList;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.troopes.android.R;
import com.troopes.android.common.BaseViewHolder;
import com.troopes.android.data.model.Product;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridListProductHolder extends BaseViewHolder implements View.OnClickListener {

    public OnViewHolderClickListener onViewHolderClickListener;
    @BindView(R.id.product_listing_product_image)
    ImageView productImage;
    @BindView(R.id.product_listing_product_name)
    TextView productName;
    @BindView(R.id.product_listing_product_cost)
    TextView productCost;
    @BindView(R.id.product_listing_product_quantity_sold)
    TextView productQuantitySold;

    public GridListProductHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(Product product) {
        productName.setText(product.name);
        String costMessage = "Rs " + String.valueOf(product.cost);
        productCost.setText(costMessage);
        String quantitySoldMessage = "sold " + String.valueOf(product.itemsSold) + " pieces";
        productQuantitySold.setText(quantitySoldMessage);
        // TODO: set image dynamically
        Glide.with(itemView.getContext())
                .load(ContextCompat.getDrawable(itemView.getContext(), R.drawable.sample_product))
                .into(productImage);
    }

    @Override
    protected void setOnViewHolderClick(BaseViewHolder.OnViewHolderClickListener onViewHolderClickListener) {
        this.onViewHolderClickListener = onViewHolderClickListener;
    }

    @Override
    public void onClick(View v) {
        if (onViewHolderClickListener != null) {
            onViewHolderClickListener.onViewHolderClick(this);
        }
    }
}