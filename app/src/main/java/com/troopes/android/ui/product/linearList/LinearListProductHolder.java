package com.troopes.android.ui.product.linearList;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.troopes.android.R;
import com.troopes.android.common.BaseViewHolder;
import com.troopes.android.data.model.Product;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LinearListProductHolder extends BaseViewHolder {
    @BindView(R.id.product_name)
    TextView name;
    @BindView(R.id.product_cost)
    TextView cost;
    @BindView(R.id.product_quantity_sold)
    TextView quantitySold;
    @BindView(R.id.product_image)
    ImageView image;
    @BindView(R.id.goto_product_list_button)
    Button gotoProductButton;

    private static final String CURRENCY = "Rs ";

    public LinearListProductHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(Product product) {
        name.setText(product.name);
        String costString = CURRENCY + String.valueOf(product.cost);
        cost.setText(costString);
        String itemsSoldMessage = "Sold "+ String.valueOf(product.itemsSold) + " pieces";
        quantitySold.setText(itemsSoldMessage);
        gotoProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(itemView.getContext(), "Going to product page..", Toast.LENGTH_SHORT).show();
            }
        });
        Picasso.get().load(product.imageUrl).fit().centerCrop().into(image);
    }
}
