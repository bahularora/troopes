package com.troopes.android.ui.product.gridList;


import android.view.View;

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
    protected void init(View view) {
        super.init(view);

        // TODO::
    }
}
