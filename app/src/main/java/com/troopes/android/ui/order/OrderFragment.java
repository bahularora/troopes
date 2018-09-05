package com.troopes.android.ui.order;

import android.view.View;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;

public class OrderFragment extends BaseFragment {

    public static OrderFragment newInstance() {
        return new OrderFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.order_fragment;
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
