package com.troopes.android.ui.product;


import android.view.View;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;

public class ProductFragment extends BaseFragment {

    public static ProductFragment newInstance(String param1, String param2) {
        return new ProductFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.product_fragment;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return 0;
    }

    @Override
    protected void init(View view) {
        super.init(view);
    }
}
