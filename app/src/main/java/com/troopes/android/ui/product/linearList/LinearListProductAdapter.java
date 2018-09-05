package com.troopes.android.ui.product.linearList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.R;
import com.troopes.android.data.model.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class LinearListProductAdapter extends RecyclerView.Adapter<LinearListProductHolder> {

    // TODO - do something and getProduct
    ArrayList<Product> data = new ArrayList<>();

    private ArrayList<Product> getSomeSampleData() {
        Product one = new Product("lakme", 200, 10101);
        Product two = new Product("two", 200, 20101);
        Product three = new Product("HP Ak007tx", 60000, 4642);
        Product four = new Product("Predator", 80000, 353);
        Product five = new Product("Thinkpad", 200000, 599);
        Product six = new Product("iPhone X", 100000, 101);
        ArrayList<Product> temp = new ArrayList<>(Arrays.asList(one, two, three, four, five, six));
        return temp;
    }

    public LinearListProductAdapter() {
        data = getSomeSampleData();
    }

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
