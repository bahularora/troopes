package com.troopes.android.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.troopes.android.data.model.Category;
import com.troopes.android.data.model.Product;
import com.troopes.android.data.model.SubCategory;

import java.util.ArrayList;
import java.util.Arrays;

public class CategoryViewModel extends ViewModel {

    private ArrayList<Product> data;
    private ArrayList<SubCategory> subCategories;
    private ArrayList<Category> categories;

    public CategoryViewModel() {
        data = setCategoryProduct();
        subCategories = getSubCategories();
        categories = getCategories();
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

    private ArrayList<Product> setCategoryProduct() {
        Product one = new Product("lakme", 200, 10101);
        Product two = new Product("two", 200, 20101);
        Product three = new Product("HP Ak007tx", 60000, 4642);
        Product four = new Product("Predator", 80000, 353);
        Product five = new Product("Thinkpad", 200000, 599);
        Product six = new Product("iPhone X", 100000, 101);
        return new ArrayList<>(Arrays.asList(one, two, three, four, five, six));
    }

    public ArrayList<Product> getCategoryProduct() {
        return data;
    }

    public int getCategoriesCount() {
        return categories.size();
    }

    public Category getCategory(int position) {
        return categories.get(position);
    }
}
