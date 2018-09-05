package com.troopes.android.ui.product.gridList;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;

public class ProductGridListFragment extends BaseFragment {

    public static ProductGridListFragment newInstance() {
        return new ProductGridListFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.product_grid_list_fragment;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.product_grid_list_fragment, container, false);
    }

}
