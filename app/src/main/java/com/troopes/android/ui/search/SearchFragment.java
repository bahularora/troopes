package com.troopes.android.ui.search;


import android.view.View;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;

public class SearchFragment extends BaseFragment {

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.search_fragment;
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
