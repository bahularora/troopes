package com.troopes.android.ui.home.all;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.data.model.Product;
import com.troopes.android.R;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductAdapter extends RecyclerView.Adapter<ProductHolder> {

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

    public ProductAdapter() {
        data = getSomeSampleData();
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.holder_product, viewGroup, false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder productHolder, int position) {
        productHolder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
