package com.troopes.android.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.troopes.android.R;
import com.troopes.android.data.model.product.Color;
import com.troopes.android.data.model.product.Product;
import com.troopes.android.data.model.product.Size;
import com.troopes.android.data.model.product.Variant;

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
        ArrayList<Color> colors = setColors();
        ArrayList<Size> sizeList = setSizeList();
        ArrayList<Variant> variantList = setVariantList();
        ArrayList<String> productImagesUrl = setProductImagesUrl();
        Product one = new Product(101, "lakme", 200, 10101, "http://www.bidjeeto.com/img/files/image/Benq_MP515.jpg", colors, sizeList, variantList, productImagesUrl);
        Product two = new Product(210, "two", 200, 20101, "http://www.bidjeeto.com/img/files/image/Creative-GigaWorks-T20-Series-II.jpg", colors, sizeList, variantList, productImagesUrl);
        Product three = new Product(133, "HP Ak007tx", 60000, 4642, "http://www.bidjeeto.com/img/files/image/LG-22LE5300-TV.jpg", colors, sizeList, variantList, productImagesUrl);
        Product four = new Product(24, "Predator", 80000, 353, "http://www.bidjeeto.com/img/files/image/HTC%20Tattoo%20A3288.jpg", colors, sizeList, variantList, productImagesUrl);
        Product five = new Product(351, "Thinkpad", 200000, 599, "http://www.bidjeeto.com/img/files/image/Sony_NWZ_B153_B150_B_Series_Demo.jpg", colors, sizeList, variantList, productImagesUrl);
        Product six = new Product(124, "iPhone X", 100000, 101, "http://www.bidjeeto.com/img/files/image/Sony%20Ericsson%20T715.jpg", colors, sizeList, variantList, productImagesUrl);
        return new ArrayList<>(Arrays.asList(one, two, three, four, five, six));
    }

    private ArrayList<String> setProductImagesUrl() {
        return new ArrayList<>(Arrays.asList("http://www.bidjeeto.com/img/files/image/Products/headphone2.jpg",
                "http://www.bidjeeto.com/img/files/image/Products/lenovo_S10-3_black.jpg",
                "http://www.bidjeeto.com/img/files/image/Products/Logitech%20QuickCam%20IM.jpg",
                "https://images.pexels.com/photos/21492/pexels-photo.jpg"));
    }

    private ArrayList<Color> setColors() {
        return new ArrayList<>(Arrays.asList(new Color("Black", android.graphics.Color.BLACK),
                new Color("Blue", android.graphics.Color.BLUE),
                new Color("Green", android.graphics.Color.GREEN),
                new Color("Yellow", android.graphics.Color.YELLOW)));
    }

    private ArrayList<Size> setSizeList() {
        return new ArrayList<>(Arrays.asList(new Size("S"),
                new Size("M"),
                new Size("L"),
                new Size("XL"),
                new Size("XXL")));
    }

    private ArrayList<Variant> setVariantList() {
        return new ArrayList<>(Arrays.asList(new Variant("https://images.pexels.com/photos/21492/pexels-photo.jpg"),
                new Variant("http://www.bidjeeto.com/img/files/image/Products/Logitech%20QuickCam%20IM.jpg"),
                new Variant("http://www.bidjeeto.com/img/files/image/Products/Nokia-1280-Inexpensive-and-Cheapest-Phone-Technical-Specifications-Reviews-and-Price-in-India.jpg"),
                new Variant("http://www.bidjeeto.com/img/files/image/Products/lenovo_S10-3_black.jpg"),
                new Variant("http://www.bidjeeto.com/img/files/image/Products/xbox-360-arcade.jpg"),
                new Variant("http://www.bidjeeto.com/img/files/image/Products/headphone2.jpg")));
    }

    public ArrayList<Product> getAllProductList() {
        return data;
    }

    public ArrayList<Integer> getBannerImages() {
        return bannerImages;
    }

}
