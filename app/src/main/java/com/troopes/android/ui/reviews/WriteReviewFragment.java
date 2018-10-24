package com.troopes.android.ui.reviews;


import android.view.View;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;


public class WriteReviewFragment extends BaseFragment {


    public static WriteReviewFragment newInstance() {
        return new WriteReviewFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.write_review_fragment;
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
