package com.troopes.android.common;

import android.support.v7.widget.RecyclerView;

import com.troopes.android.data.model.Product;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class BaseAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    private ArrayList<Product> data;

    public BaseAdapter() {
        data = getSomeSampleData();
    }

    private ArrayList<Product> getSomeSampleData() {
        Product one = new Product("lakme", 200, 10101);
        Product two = new Product("two", 200, 20101);
        Product three = new Product("HP Ak007tx", 60000, 4642);
        Product four = new Product("Predator", 80000, 353);
        Product five = new Product("Thinkpad", 200000, 599);
        Product six = new Product("iPhone X", 100000, 101);
        return new ArrayList<>(Arrays.asList(one, two, three, four, five, six));
    }

    protected ArrayList<Product> getSampleData() {
        return data;
    }

    protected void setOnItemClickListener(OnItemClickListener onItemClickListener) {
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
