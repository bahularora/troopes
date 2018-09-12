package com.troopes.android.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.troopes.android.R;
import com.troopes.android.data.model.Category;
import com.troopes.android.data.model.Search;
import com.troopes.android.data.model.SubCategory;
import com.troopes.android.data.model.product.Color;
import com.troopes.android.data.model.product.Product;
import com.troopes.android.data.model.product.Size;
import com.troopes.android.data.model.product.Variant;

import java.util.ArrayList;
import java.util.Arrays;

public class MainViewModel extends ViewModel {

    private ArrayList<Product> allProducts;
    private ArrayList<Product> categoryProducts;
    private ArrayList<Integer> bannerImages = new ArrayList<>();
    private ArrayList<SubCategory> subCategories;
    private ArrayList<Category> categories;
    private ArrayList<Search> sectionNameList;

    public MainViewModel() {
        allProducts = setAllProductsData();
        categoryProducts = setCategoryProducts();
        subCategories = getSubCategories();
        categories = getCategories();
        sectionNameList = setSearchSectionList();
        bannerImages.addAll(Arrays.asList(R.drawable.sample_viewpager1, R.drawable.sample_viewpager2, R.drawable.sample_viewpager3, R.drawable.sample_viewpager4));
    }

    private ArrayList<Product> setAllProductsData() {
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

    private ArrayList<Category> getCategories() {
        Category one = new Category("clothes", "imageurl1", subCategories);
        Category two = new Category("shoes", "imageurl1", subCategories);
        Category three = new Category("electronics", "imageurl1", subCategories);
        Category four = new Category("mobile", "imageurl1", subCategories);
        Category five = new Category("sports", "imageurl1", subCategories);
        Category six = new Category("luxury", "imageurl1", subCategories);
        Category seven = new Category("books", "imageurl1", subCategories);
        Category eight = new Category("movies", "imageurl1", subCategories);
        Category nine = new Category("furniture", "imageurl1", subCategories);
        return new ArrayList<>(Arrays.asList(one, two, three, four, five, six, seven, eight, nine));
    }

    private ArrayList<SubCategory> getSubCategories() {
        SubCategory one = new SubCategory("sub cat 1", "https://www.google.com/");
        SubCategory two = new SubCategory("sub cat 2", "https://www.google.org/");
        SubCategory three = new SubCategory("sub cat 3", "https://www.google.in/");
        SubCategory four = new SubCategory("sub cat 4", "https://www.google.de/");
        SubCategory five = new SubCategory("sub cat 5", "https://www.google.jr/");
        SubCategory six = new SubCategory("sub cat 6", "https://www.google.fr/");
        SubCategory seven = new SubCategory("sub cat 7", "https://www.google.usa/");
        SubCategory eight = new SubCategory("sub cat 8", "https://www.google.uk/");
        SubCategory nine = new SubCategory("sub cat 9", "https://www.google.com/");
        return new ArrayList<>(Arrays.asList(one, two, three, four, five, six, seven, eight, nine));
    }

    private ArrayList<Product> setCategoryProducts() {
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

    private ArrayList<Search> setSearchSectionList() {
        SubCategory one = new SubCategory("sub cat1", "http://www.google.com");
        SubCategory two = new SubCategory("sub shoes", "http://www.google.com");
        SubCategory three = new SubCategory("sub c", "http://www.google.org");
        SubCategory four = new SubCategory("sub cat1", "http://www.google.com");
        SubCategory five = new SubCategory("books", "http://www.google.com");
        SubCategory six = new SubCategory("mobiles", "http://www.google.com");
        SubCategory seven = new SubCategory("others", "http://www.google.com");
        ArrayList<SubCategory> list2 = new ArrayList<>(Arrays.asList(one, two, three, four, five, six, seven));
        ArrayList<SubCategory> list1 = new ArrayList<>(Arrays.asList(one, two, three, four, five, six));

        Search o1 = new Search("shoes", "url", list1);
        Search o2 = new Search("men", "url", list2);
        Search o3 = new Search("women", "url", list1);
        Search o4 = new Search("kids", "url", list2);
        Search o5 = new Search("sports", "url", list2);
        Search o6 = new Search("accessories", "url", list1);
        Search o7 = new Search("gadgets", "url", list1);
        Search o8 = new Search("shoes", "url", list1);
        Search o9 = new Search("make-up", "url", list2);

        return new ArrayList<>(Arrays.asList(o1, o2, o3, o4, o5, o6, o7, o8, o9));
    }

    public ArrayList<Search> getSearchSectionList() {
        return sectionNameList;
    }

    public ArrayList<Product> getCategoryProducts() {
        return categoryProducts;
    }

    public ArrayList<Category> getCategoryList() {
        return categories;
    }

    public int getCategoriesCount() {
        return categories.size();
    }

    public Category getCategory(int position) {
        return categories.get(position);
    }

    public ArrayList<Product> getAllProductList() {
        return allProducts;
    }

    public ArrayList<Integer> getBannerImages() {
        return bannerImages;
    }

}
