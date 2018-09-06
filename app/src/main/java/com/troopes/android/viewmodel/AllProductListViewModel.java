package com.troopes.android.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.troopes.android.R;
import com.troopes.android.data.model.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class AllProductListViewModel extends ViewModel {

    private ArrayList<Product> data;
    private ArrayList<Integer> bannerImages = new ArrayList<>();

    public AllProductListViewModel() {
        data = getSampleData();

        // sample banner images
        bannerImages.addAll(Arrays.asList(R.drawable.sample_viewpager1, R.drawable.sample_viewpager2, R.drawable.sample_viewpager3, R.drawable.sample_viewpager4));
    }

    private ArrayList<Product> getSampleData() {
        Product one = new Product("lakme", 200, 10101);
        Product two = new Product("two", 200, 20101);
        Product three = new Product("HP Ak007tx", 60000, 4642);
        Product four = new Product("Predator", 80000, 353);
        Product five = new Product("Thinkpad", 200000, 599);
        Product six = new Product("iPhone X", 100000, 101);
        return new ArrayList<>(Arrays.asList(one, two, three, four, five, six));
    }

    public ArrayList<Product> getAllProductList() {
        return data;
    }

    public ArrayList<Integer> getBannerImages() {
        return bannerImages;
    }

}
