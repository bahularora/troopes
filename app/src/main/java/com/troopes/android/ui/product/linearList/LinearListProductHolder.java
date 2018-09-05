package com.troopes.android.ui.product.linearList;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.troopes.android.R;
import com.troopes.android.data.model.Product;

public class LinearListProductHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView cost;
    private TextView quantitySold;
    private ImageView image;
    private Button gotoProductButton;

    private static final String CURRENCY = "Rs ";

    public LinearListProductHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(@NonNull View itemView) {
        name = itemView.findViewById(R.id.product_name);
        cost = itemView.findViewById(R.id.product_cost);
        quantitySold = itemView.findViewById(R.id.product_quantity_sold);
        gotoProductButton = itemView.findViewById(R.id.goto_product_list_button);
        image = itemView.findViewById(R.id.product_image);
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
        Glide.with(itemView.getContext())
                .load(ContextCompat.getDrawable(itemView.getContext(), R.drawable.sample_product))
                .into(image);
    }
}
