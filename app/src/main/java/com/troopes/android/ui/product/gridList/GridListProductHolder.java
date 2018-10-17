package com.troopes.android.ui.product.gridList;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.troopes.android.R;
import com.troopes.android.common.BaseViewHolder;
import com.troopes.android.data.modelDummy.product.Product;

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
        itemView.setOnClickListener(this);
    }

    public void bindData(Product product) {
        productName.setText(product.name);
        String costMessage = "Rs " + String.valueOf(product.cost);
        productCost.setText(costMessage);
        String quantitySoldMessage = "sold " + String.valueOf(product.itemsSold) + " pieces";
        productQuantitySold.setText(quantitySoldMessage);
        Picasso.get().load(product.imageUrl).fit().into(productImage);
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