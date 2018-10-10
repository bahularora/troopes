package com.troopes.android.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.troopes.android.R;
import com.troopes.android.data.constants.ORDER_STATUS;
import com.troopes.android.data.model.Category;
import com.troopes.android.data.model.Order;
import com.troopes.android.data.model.Search;
import com.troopes.android.data.model.SubCategory;
import com.troopes.android.data.model.Tag;
import com.troopes.android.data.model.Wishlist;
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
    private ArrayList<Tag> trendingTagsList;
    private ArrayList<Order> orderList;
    private ArrayList<Wishlist> wishlists;

    public MainViewModel() {
        allProducts = setAllProductsData();
        categoryProducts = setCategoryProducts();
        subCategories = getSubCategories();
        categories = getCategories();
        sectionNameList = setSearchSectionList();
        trendingTagsList = setTrendingTags();
        orderList = setOrderList();
        wishlists = setWishList();
        bannerImages.addAll(Arrays.asList(R.drawable.sample_viewpager1, R.drawable.sample_viewpager2, R.drawable.sample_viewpager3, R.drawable.sample_viewpager4));
    }

    private ArrayList<Order> setOrderList() {
        Order one = new Order(342, 352, "2/3/18", ORDER_STATUS.CANCELLED, "lakme", 435, 10101, 57, null, "http://www.bidjeeto.com/img/files/image/Benq_MP515.jpg");
        Order two = new Order(46, 2362, "6/3/18", ORDER_STATUS.DELIVERED, "fanideaz Men's Cotton Polo (Fmps5002)", 10007, 20101, 51, null, "http://www.bidjeeto.com/img/files/image/Creative-GigaWorks-T20-Series-II.jpg");
        Order three = new Order(373, 262, "2/6/18", ORDER_STATUS.DELIVERED, "HP Ak007tx", 60000, 66642, 10, null, "http://www.bidjeeto.com/img/files/image/LG-22LE5300-TV.jpg");
        Order four = new Order(32642, 2662, "2/10/18", ORDER_STATUS.PENDING, "Predator", 80000, 93353, 15, null, "http://www.bidjeeto.com/img/files/image/HTC%20Tattoo%20A3288.jpg");
        Order five = new Order(537, 262, "12/7/18", ORDER_STATUS.CANCELLED, "Blackberrys - Brown Printed Slim Fit Formal Shirt", 20000, 59934, 79, null, "http://www.bidjeeto.com/img/files/image/Sony_NWZ_B153_B150_B_Series_Demo.jpg");
        return new ArrayList<>(Arrays.asList(one, two, three, four, five));
    }

    private ArrayList<Wishlist> setWishList() {
        Wishlist one = new Wishlist(342, "lakme", 435, 10101, 57, null, "http://www.bidjeeto.com/img/files/image/Benq_MP515.jpg");
        Wishlist two = new Wishlist(46, "fanideaz Men's Cotton Polo (Fmps5002)", 10007, 20101, 51, null, "http://www.bidjeeto.com/img/files/image/Creative-GigaWorks-T20-Series-II.jpg");
        Wishlist three = new Wishlist(373, "HP Ak007tx", 60000, 66642, 10, null, "http://www.bidjeeto.com/img/files/image/LG-22LE5300-TV.jpg");
        Wishlist four = new Wishlist(32642, "Predator", 80000, 93353, 15, null, "http://www.bidjeeto.com/img/files/image/HTC%20Tattoo%20A3288.jpg");
        Wishlist five = new Wishlist(537, "Blackberrys - Brown Printed Slim Fit Formal Shirt", 20000, 59934, 79, null, "http://www.bidjeeto.com/img/files/image/Sony_NWZ_B153_B150_B_Series_Demo.jpg");
        return new ArrayList<>(Arrays.asList(one, two, three, four, five));
    }

    private ArrayList<Tag> setTrendingTags() {
        Tag one = new Tag("tag1", "");
        Tag two = new Tag("shoes", "");
        Tag three = new Tag("book", "");
        Tag four = new Tag("nokia 6.1", "");
        Tag five = new Tag("zenforce max pro", "");
        Tag six = new Tag("u", "");
        Tag seven = new Tag("hello", "");
        Tag eight = new Tag("hp", "");
        Tag nine = new Tag("21 tips of 21 century", "");
        Tag ten = new Tag("tag10", "");
        Tag eleven = new Tag("11", "");
        return new ArrayList<>(Arrays.asList(one, two, three, four, five, six, seven, eight, nine, ten, eleven));
    }

    private ArrayList<Product> setAllProductsData() {
        ArrayList<Color> colors = setColors();
        ArrayList<Size> sizeList = setSizeList();
        ArrayList<Variant> variantList = setVariantList();
        ArrayList<String> productImagesUrl = setProductImagesUrl();
        Product one = new Product(101, "lakme", 200, 10101, "http://www.bidjeeto.com/img/files/image/Benq_MP515.jpg", colors, sizeList, variantList, productImagesUrl);
        Product two = new Product(210, "fanideaz Men's Cotton Polo (Fmps5002)", 200, 20101, "http://www.bidjeeto.com/img/files/image/Creative-GigaWorks-T20-Series-II.jpg", colors, sizeList, variantList, productImagesUrl);
        Product three = new Product(133, "HP Ak007tx", 60000, 4642, "http://www.bidjeeto.com/img/files/image/LG-22LE5300-TV.jpg", colors, sizeList, variantList, productImagesUrl);
        Product four = new Product(24, "Predator", 80000, 353, "http://www.bidjeeto.com/img/files/image/HTC%20Tattoo%20A3288.jpg", colors, sizeList, variantList, productImagesUrl);
        Product five = new Product(351, "Blackberrys - Brown Printed Slim Fit Formal Shirt", 200000, 599, "http://www.bidjeeto.com/img/files/image/Sony_NWZ_B153_B150_B_Series_Demo.jpg", colors, sizeList, variantList, productImagesUrl);
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
        SubCategory one = new SubCategory("sub cat 1", "http://i1168.photobucket.com/albums/r489/annardlp/5_zps8jd5cygz.jpg");
        SubCategory two = new SubCategory("sub cat 2", "http://i484.photobucket.com/albums/rr202/padre_negro/100px/Underfire-front-1.jpg");
        SubCategory three = new SubCategory("sub cat 3", "http://i814.photobucket.com/albums/zz68/skidpalace/1997%20Harley%20Davidson%20Softail%20Custom/6ddcfb9f-7dc2-4c33-95ab-50a0d753dc91_zps959d36aa.jpg");
        SubCategory four = new SubCategory("sub cat 4", "http://i208.photobucket.com/albums/bb268/ikki831/patches_closeUp100.gif");
        SubCategory five = new SubCategory("sub cat 5", "http://i675.photobucket.com/albums/vv115/emomusicislife/eye.jpg");
        SubCategory six = new SubCategory("sub cat 6", "http://i1290.photobucket.com/albums/b525/thespinnage/eye.jpg");
        SubCategory seven = new SubCategory("sub cat 7", "http://i1183.photobucket.com/albums/x479/HatsuneMiku7/Lily-100px.png");
        SubCategory eight = new SubCategory("sub cat 8", "http://i1290.photobucket.com/albums/b538/AG-PixelGod/AG%20Armatars/b8770446-5ab3-4416-afd5-16823bb8f3d7_zpse0691492.jpg");
        SubCategory nine = new SubCategory("sub cat 9", "http://i137.photobucket.com/albums/q224/moon_wolf363/TC2/isolated14.gif");
        return new ArrayList<>(Arrays.asList(one, two, three, four, five, six, seven, eight, nine));
    }

    private ArrayList<Product> setCategoryProducts() {
        ArrayList<Color> colors = setColors();
        ArrayList<Size> sizeList = setSizeList();
        ArrayList<Variant> variantList = setVariantList();
        ArrayList<String> productImagesUrl = setProductImagesUrl();
        Product one = new Product(101, "lakme", 200, 10101, "http://www.bidjeeto.com/img/files/image/Benq_MP515.jpg", colors, sizeList, variantList, productImagesUrl);
        Product two = new Product(210, "fanideaz Men's Cotton Polo (Fmps5002)", 200, 20101, "http://www.bidjeeto.com/img/files/image/Creative-GigaWorks-T20-Series-II.jpg", colors, sizeList, variantList, productImagesUrl);
        Product three = new Product(133, "HP Ak007tx", 60000, 4642, "http://www.bidjeeto.com/img/files/image/LG-22LE5300-TV.jpg", colors, sizeList, variantList, productImagesUrl);
        Product four = new Product(24, "Predator", 80000, 353, "http://www.bidjeeto.com/img/files/image/HTC%20Tattoo%20A3288.jpg", colors, sizeList, variantList, productImagesUrl);
        Product five = new Product(351, "Blackberrys - Brown Printed Slim Fit Formal Shirt", 20000, 599, "http://www.bidjeeto.com/img/files/image/Sony_NWZ_B153_B150_B_Series_Demo.jpg", colors, sizeList, variantList, productImagesUrl);
        Product six = new Product(124, "iPhone X", 10000, 101, "http://www.bidjeeto.com/img/files/image/Sony%20Ericsson%20T715.jpg", colors, sizeList, variantList, productImagesUrl);
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

    public ArrayList<Tag> getTrendingTags() {
        return trendingTagsList;
    }

    public Product getProduct(long productId) {
        return allProducts.get((int) (productId % allProducts.size()));
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public ArrayList<Wishlist> getWishlists() {
        return wishlists;
    }
}
