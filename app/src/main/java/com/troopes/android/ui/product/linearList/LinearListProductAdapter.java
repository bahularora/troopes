package com.troopes.android.ui.product.linearList;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;
import com.troopes.android.data.model.Product;

import java.util.ArrayList;

public class LinearListProductAdapter extends BaseAdapter<LinearListProductHolder> {

    ArrayList<Product> data = new ArrayList<>();

    @NonNull
    @Override
    public LinearListProductHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.holder_product, viewGroup, false);
        return new LinearListProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LinearListProductHolder productHolder, int position) {
        productHolder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
