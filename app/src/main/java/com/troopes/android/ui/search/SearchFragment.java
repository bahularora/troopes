package com.troopes.android.ui.search;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.data.modelDummy.Search;
import com.troopes.android.viewmodel.MainViewModel;

import java.util.ArrayList;

import butterknife.BindView;

public class SearchFragment extends BaseFragment implements BaseAdapter.OnItemClickListener {

    private static final String ARG_IS_TRENDING = "isTrending";
    @BindView(R.id.trending_tags)
    RecyclerView trendingTags;
    @BindView(R.id.recent_tags)
    RecyclerView recentTags;

    @BindView(R.id.search_section_name_list)
    RecyclerView sectionNameList;
    @BindView(R.id.search_section_list)
    RecyclerView sectionList;
    @BindView(R.id.trending_subsection)
    ConstraintLayout trendingLayout;
    @BindView(R.id.search_subsection)
    ConstraintLayout searchLayout;
    private boolean isTrending;

    private SectionNameAdapter sectionNameAdapter;
    private SectionAdapter searchSectionAdapter;
    private TagAdapter tagAdapter;
    private TagAdapter recentTagAdapter;
    private LinearLayoutManager sectionListLayoutManager;

    private MainViewModel mainViewModel;

    public static SearchFragment newInstance(boolean isTrending) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putBoolean(ARG_IS_TRENDING, isTrending);
        fragment.setArguments(args);
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
        if (getActivity() == null) {
            return;
        }

        if (getArguments() != null) {
            isTrending = getArguments().getBoolean(ARG_IS_TRENDING);
        }

        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        if (isTrending) {
            Log.i("SEARCH", "isTrending " + true);
            searchLayout.setVisibility(View.GONE);
            tagAdapter = new TagAdapter();
            tagAdapter.setData(mainViewModel.getTrendingTags());
            recentTagAdapter = new TagAdapter();
            recentTagAdapter.setData(mainViewModel.getTrendingTags());

            FlexboxLayoutManager tagLayoutManager = new FlexboxLayoutManager(view.getContext());
            tagLayoutManager.setFlexDirection(FlexDirection.ROW);
            tagLayoutManager.setFlexWrap(FlexWrap.WRAP);
            tagLayoutManager.setJustifyContent(JustifyContent.SPACE_AROUND);

            FlexboxLayoutManager recentTagLayoutManager = new FlexboxLayoutManager(view.getContext());
            recentTagLayoutManager.setFlexDirection(FlexDirection.ROW);
            recentTagLayoutManager.setFlexWrap(FlexWrap.WRAP);
            recentTagLayoutManager.setJustifyContent(JustifyContent.SPACE_AROUND);

            recentTags.setAdapter(recentTagAdapter);
            recentTags.setLayoutManager(recentTagLayoutManager);

            trendingTags.setAdapter(tagAdapter);
            trendingTags.setLayoutManager(tagLayoutManager);
        } else {
            Log.i("SEARCH", "isTrending " + false);
            trendingLayout.setVisibility(View.GONE);
            sectionNameAdapter = new SectionNameAdapter();
            sectionNameAdapter.setOnItemClickListener(this);
            searchSectionAdapter = new SectionAdapter();

            ArrayList<Search> searchSectionList = mainViewModel.getSearchSectionList();
            searchSectionAdapter.setData(searchSectionList);
            sectionNameAdapter.setSearchItemList(searchSectionList);

            LinearLayoutManager sectionNameListLayoutManager = new LinearLayoutManager(view.getContext());
            sectionNameListLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

            sectionListLayoutManager = new LinearLayoutManager(view.getContext());
            sectionListLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

            sectionNameList.setAdapter(sectionNameAdapter);
            sectionNameList.setLayoutManager(sectionNameListLayoutManager);
            sectionList.setAdapter(searchSectionAdapter);
            sectionList.setLayoutManager(sectionListLayoutManager);
        }
    }

    @Override
    public void onItemClick(int position) {
        if (!isTrending) {
            sectionListLayoutManager.scrollToPositionWithOffset(position, 0);
            searchSectionAdapter.notifyDataSetChanged();
        }
    }
}
