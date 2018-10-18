package com.troopes.android.ui.home.category;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.data.modelDummy.SubCategory;
import com.troopes.android.data.modelDummy.product.Product;
import com.troopes.android.ui.product.ProductActivity;
import com.troopes.android.ui.product.gridList.ProductGridListAdapter;
import com.troopes.android.utils.GridSpacingItemDecoration;
import com.troopes.android.viewmodel.MainViewModel;

import java.util.ArrayList;

import butterknife.BindView;


public class CategoryFragment extends BaseFragment implements BaseAdapter.OnItemClickListener {

    private static final String ARG_CATEGORY_ID = "categoryId";
    private static final String ARG_PRODUCT_ID = "productId";

    private int categoryId;

    @BindView(R.id.sub_category_list)
    RecyclerView subCategoryList;
    @BindView(R.id.product_grid_listing)
    RecyclerView productList;

    private MainViewModel mainViewModel;

    public static CategoryFragment newInstance(int categoryId) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_CATEGORY_ID, categoryId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.category_fragment;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return 0;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        if (getActivity() == null) {
            return;
        }
        if (getArguments() != null) {
            categoryId = getArguments().getInt(ARG_CATEGORY_ID);
        }

        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        SubCategoryAdapter subCategoryAdapter = new SubCategoryAdapter();
        ProductGridListAdapter productGridListAdapter = new ProductGridListAdapter();

        int subCategoryListGridCount = calculateNoOfColumns(view.getContext());
        GridLayoutManager subCategoryLayoutManager = new GridLayoutManager(view.getContext(), subCategoryListGridCount);
        GridLayoutManager productGridLayoutManager = new GridLayoutManager(view.getContext(), 2);

        ArrayList<SubCategory> subCategories = mainViewModel.getCategory(categoryId).getSubCategories();
        ArrayList<Product> products = mainViewModel.getCategoryProducts();

        subCategoryAdapter.setSubCategories(subCategories);
        subCategoryList.setAdapter(subCategoryAdapter);
        subCategoryList.addItemDecoration(new GridSpacingItemDecoration(subCategoryListGridCount, 6, true));
        subCategoryList.setLayoutManager(subCategoryLayoutManager);
        ViewCompat.setNestedScrollingEnabled(subCategoryList, false);

        productGridListAdapter.setProductList(products);
        productGridListAdapter.setOnItemClickListener(this);
        productList.setAdapter(productGridListAdapter);
        productList.addItemDecoration(new GridSpacingItemDecoration(2, 6, true));
        productList.setLayoutManager(productGridLayoutManager);
        ViewCompat.setNestedScrollingEnabled(productList, false);

    }

    private int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        // here 72 is the dp width of each sub category viewholder , 6 for padding
        return (int) (dpWidth / (72 + 12));
    }

    @Override
    public void onItemClick(int position, String name) {
        long productId = mainViewModel.getAllProductList().get(position).productId;
        Intent intent = new Intent(getActivity(), ProductActivity.class);
        intent.putExtra(ARG_PRODUCT_ID, productId);
        startActivity(intent);
    }
}
