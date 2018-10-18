package com.troopes.android.ui.home;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.ui.product.gridList.ProductGridListAdapter;
import com.troopes.android.viewmodel.MainViewModel;

import butterknife.BindView;

public class SubCategoryFragment extends BaseFragment {
    private static final String ARG_SUB_CATEGORY_ID = "subcategoryId";

    @BindView(R.id.sub_category_products)
    RecyclerView subCategoryProducts;
    private ProductGridListAdapter productGridListAdapter;

    private MainViewModel mainViewModel;

    private long subCategoryId;

    public static SubCategoryFragment newInstance(long subCategoryId) {
        SubCategoryFragment fragment = new SubCategoryFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_SUB_CATEGORY_ID, subCategoryId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.sub_category_fragment;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return 0;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        if (getActivity() != null) {
            return;
        }
        if (getArguments() != null) {
            subCategoryId = getArguments().getLong(ARG_SUB_CATEGORY_ID);
        }
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        productGridListAdapter = new ProductGridListAdapter();
        // TODO getSubCategoryProducts
        productGridListAdapter.setProductList(mainViewModel.getCategoryProducts());

        GridLayoutManager glm = new GridLayoutManager(view.getContext(), 2);

        subCategoryProducts.setAdapter(productGridListAdapter);
        subCategoryProducts.setLayoutManager(glm);
    }
}
