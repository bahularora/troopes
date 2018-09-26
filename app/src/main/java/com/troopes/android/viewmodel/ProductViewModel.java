package com.troopes.android.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.troopes.android.data.model.Review;
import com.troopes.android.data.model.product.Color;
import com.troopes.android.data.model.product.Product;
import com.troopes.android.data.model.product.Size;
import com.troopes.android.data.model.product.Variant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductViewModel extends ViewModel {

    private Product product;
    private ArrayList<Product> similarProductList;
    private ArrayList<Review> reviews;

    public ProductViewModel() {
        product = setProductDetail(101);
        similarProductList = setSimilarProducts(101);
        reviews = setReviews();
    }

    private ArrayList<Product> setSimilarProducts(long productId) {
        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(new Color("Black", android.graphics.Color.BLACK),
                new Color("Blue", android.graphics.Color.BLUE),
                new Color("Green", android.graphics.Color.GREEN),
                new Color("Yellow", android.graphics.Color.YELLOW)));
        ArrayList<Size> sizeList = new ArrayList<>(Arrays.asList(new Size("S"),
                new Size("M"),
                new Size("L"),
                new Size("XL"),
                new Size("XXL")));
        ArrayList<Variant> variantList = new ArrayList<>(Arrays.asList(new Variant("https://images.pexels.com/photos/21492/pexels-photo.jpg"),
                new Variant("http://www.bidjeeto.com/img/files/image/Products/Logitech%20QuickCam%20IM.jpg"),
                new Variant("http://www.bidjeeto.com/img/files/image/Products/Nokia-1280-Inexpensive-and-Cheapest-Phone-Technical-Specifications-Reviews-and-Price-in-India.jpg"),
                new Variant("http://www.bidjeeto.com/img/files/image/Products/lenovo_S10-3_black.jpg"),
                new Variant("http://www.bidjeeto.com/img/files/image/Products/xbox-360-arcade.jpg"),
                new Variant("http://www.bidjeeto.com/img/files/image/Products/headphone2.jpg")));
        ArrayList<String> productImagesUrl = new ArrayList<>(Arrays.asList("http://www.bidjeeto.com/img/files/image/Products/headphone2.jpg",
                "http://www.bidjeeto.com/img/files/image/Products/lenovo_S10-3_black.jpg",
                "http://www.bidjeeto.com/img/files/image/Products/Logitech%20QuickCam%20IM.jpg",
                "https://images.pexels.com/photos/21492/pexels-photo.jpg"));
        Product one = new Product(101, "lakme", 200, 10101, "http://www.bidjeeto.com/img/files/image/Benq_MP515.jpg", colors, sizeList, variantList, productImagesUrl);
        Product two = new Product(210, "two", 200, 20101, "http://www.bidjeeto.com/img/files/image/Creative-GigaWorks-T20-Series-II.jpg", colors, sizeList, variantList, productImagesUrl);
        Product three = new Product(133, "HP Ak007tx", 60000, 4642, "http://www.bidjeeto.com/img/files/image/LG-22LE5300-TV.jpg", colors, sizeList, variantList, productImagesUrl);
        Product four = new Product(24, "Predator", 80000, 353, "http://www.bidjeeto.com/img/files/image/HTC%20Tattoo%20A3288.jpg", colors, sizeList, variantList, productImagesUrl);
        Product five = new Product(351, "Thinkpad", 200000, 599, "http://www.bidjeeto.com/img/files/image/Sony_NWZ_B153_B150_B_Series_Demo.jpg", colors, sizeList, variantList, productImagesUrl);
        Product six = new Product(124, "iPhone X", 100000, 101, "http://www.bidjeeto.com/img/files/image/Sony%20Ericsson%20T715.jpg", colors, sizeList, variantList, productImagesUrl);
        return new ArrayList<>(Arrays.asList(one, two, three, four, five, six));
    }

    private Product setProductDetail(long productId) {
        ArrayList<Color> colors = setColors();
        ArrayList<Size> sizeList = setSizeList();
        ArrayList<Variant> variantList = setVariantList();
        ArrayList<String> productImagesUrl = setProductImagesUrl();
        return new Product(productId, "Flower portrait", 34204, 23355, "https://images.pexels.com/photos/1212487/pexels-photo-1212487.jpeg", colors, sizeList, variantList, productImagesUrl);
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

    private ArrayList<Review> setReviews() {
        List<String> reviewImages = Arrays.asList("http://fiveonlineclient.in/loginkar/product-images/--details-1.rice.jpg",
                "http://fiveonlineclient.in/loginkar/product-images/amul-butter--details-1.amul%20butter.gif",
                "http://fiveonlineclient.in/loginkar/product-images/amul-badam-milk-shake-tin-RD001-details-1.amul%20badam%20milk%20shake%20tin.jpg", "" +
                        "http://fiveonlineclient.in/loginkar/product-images/bledline-baby-food-Bledline%20Baby%20Food-details-1.images18.jpg",
                "http://fiveonlineclient.in/loginkar/product-images/apple-Apple-details-1.sweetie3.jpg",
                "http://fiveonlineclient.in/loginkar/product-images/apple-Apple-details-1.sweetie3.jpg",
                "http://fiveonlineclient.in/loginkar/product-images/demo-product-CAR-012-details-1.product7.jpg");

        String review = "This plot shows the distribution of salaries in USD for the top 10 metro areas in the US by number of " +
                "respondents. (Notice that the y-axis is on a log scale.) The cities are ordered from the lowest median salary " +
                "(Minneapolis) to the highest median salary (the San Francisco area). Take a look at this graph and see how " +
                "close together the median salaries for cities like Chicago, Dallas, Denver, Portland, Boston, and even Austin" +
                " are. In our modeling, the data we have only supports a statistically different salary for the cities shown " +
                "in orange. San Francisco, Seattle, and New York have developer salaries that are high enough compared to " +
                "typical US norms and enough developers working there that we can confidently predict a different salary " +
                "for a developer living in one of these cities than the US in general. For developers living in cities like " +
                "Chicago or Boston, salaries are just about the same as what is typical for the US overall, so we can’t build " +
                "a confident, separate prediction for each of these cities. You might look at this plot and wonder about cities" +
                " with salaries that appear slightly lower like Minneapolis, but there we had fewer respondents, so again we " +
                "can’t build a confident, separate prediction. In the US, we have individual city-level predictions for San " +
                "Francisco, Seattle, and New York, and then a country-level prediction that covers the rest of the US. This" +
                " same pattern holds true in other countries including France, Germany, and Canada, for the same reasons.";

        Review one = new Review("Joel", "29-8-2018", 4.3f, "variant1", "XL", "Yellow", review, reviewImages);
        Review two = new Review("Joel", "29-8-2018", 4.3f, "variant1", "XL", "Yellow", review, reviewImages);
        Review three = new Review("Joel", "29-8-2018", 4.3f, "variant1", "XL", "Yellow", review, reviewImages);
        Review four = new Review("Joel", "29-8-2018", 4.3f, "variant1", "XL", "Yellow", review, reviewImages);
        Review five = new Review("Joel", "29-8-2018", 4.3f, "variant1", "XL", "Yellow", review, reviewImages);
        Review six = new Review("Joel", "29-8-2018", 4.3f, "variant1", "XL", "Yellow", review, reviewImages);
        Review seven = new Review("Joel", "29-8-2018", 4.3f, "variant1", "XL", "Yellow", review, reviewImages);
        return new ArrayList<>(Arrays.asList(one, two, three, four, five, six, seven));
    }

    public Product getProduct(long productId) {
        return product;
    }

    public ArrayList<Product> getSimilarProductList(long productId) {
        return similarProductList;
    }

    // where will be define the product id ??
    public ArrayList<Review> latestReview(int count) {
        ArrayList<Review> temp = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            temp.add(reviews.get(i));
        }
        return temp;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }
}
