package com.troopes.android.ui.home.category;


import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.ui.product.gridList.ProductGridListAdapter;

import butterknife.BindView;


public class CategoryFragment extends BaseFragment {

    @BindView(R.id.sub_category_list)
    RecyclerView subCategoryList;
    @BindView(R.id.product_grid_listing)
    RecyclerView productList;

    public static CategoryFragment newInstance() {
        return new CategoryFragment();
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

        int subCategoryListGridCount = calculateNoOfColumns(view.getContext());
        GridLayoutManager subCategoryLayoutManager = new GridLayoutManager(view.getContext(), subCategoryListGridCount);
        subCategoryList.setAdapter(new SubCategoryAdapter());
        subCategoryList.setLayoutManager(subCategoryLayoutManager);
        ViewCompat.setNestedScrollingEnabled(subCategoryList, false);

        GridLayoutManager productGridLayoutManager = new GridLayoutManager(view.getContext(), 2);
        productList.setAdapter(new ProductGridListAdapter());
        productList.setLayoutManager(productGridLayoutManager);
        ViewCompat.setNestedScrollingEnabled(productList, false);

    }

    private int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        // here 72 is the dp width of each sub category viewholder
        return (int) (dpWidth / 72);
    }
}
