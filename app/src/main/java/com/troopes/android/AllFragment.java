package com.troopes.android;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;

public class AllFragment extends BaseFragment {

    @BindView(R.id.banner)
    ViewPager viewPager;

    @BindView(R.id.all_list)
    RecyclerView recyclerView;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_all;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return R.id.progress_bar;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager.setAdapter(new BannerAdapter(getContext()));
    }
}
