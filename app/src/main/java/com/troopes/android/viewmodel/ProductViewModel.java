package com.troopes.android.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.troopes.android.data.model.product.Color;
import com.troopes.android.data.model.product.Product;
import com.troopes.android.data.model.product.Size;
import com.troopes.android.data.model.product.Variant;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductViewModel extends ViewModel {

    private Product product;

    public ProductViewModel() {
        product = setProductDetail(101);

    }

    private Product setProductDetail(long productId) {
        ArrayList<Color> colors = setColors();
        ArrayList<Size> sizeList = setSizeList();
        ArrayList<Variant> variantList = setVariantList();
        return new Product(productId, "Flower portrait", 34204, 23355, "https://images.pexels.com/photos/1212487/pexels-photo-1212487.jpeg", colors, sizeList, variantList);
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

    public Product getProduct(long productId) {
        return product;
    }
}
