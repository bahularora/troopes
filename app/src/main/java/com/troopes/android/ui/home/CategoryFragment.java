package com.troopes.android.ui.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;


public class CategoryFragment extends BaseFragment {
    public CategoryFragment() {
        // Required empty public constructor
    }

    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_category;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

}
