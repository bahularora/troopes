package com.troopes.android.ui.search;


import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AutoCompleteTextView;

import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.data.model.Search;
import com.troopes.android.viewmodel.MainViewModel;

import java.util.ArrayList;

import butterknife.BindView;

public class SearchFragment extends BaseFragment implements BaseAdapter.OnItemClickListener {

    @BindView(R.id.search_bar)
    AutoCompleteTextView searchBar;
    @BindView(R.id.search_section_name_list)
    RecyclerView sectionNameList;
    @BindView(R.id.search_section_list)
    RecyclerView sectionList;

    private SectionNameAdapter sectionNameAdapter;
    private SectionAdapter searchSectionAdapter;
    private LinearLayoutManager sectionListLayoutManager;

    private MainViewModel mainViewModel;

    public static SearchFragment newInstance() {
        return new SearchFragment();
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

        sectionNameAdapter = new SectionNameAdapter();
        sectionNameAdapter.setOnItemClickListener(this);
        searchSectionAdapter = new SectionAdapter();
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        ArrayList<Search> searchSectionList = mainViewModel.getSearchSectionList();
        searchSectionAdapter.setData(searchSectionList);
        sectionNameAdapter.setSearchItemList(searchSectionList);

        LinearLayoutManager sectionNameListLayoutManager = new LinearLayoutManager(view.getContext());
        sectionNameListLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        sectionListLayoutManager = new LinearLayoutManager(view.getContext());
        sectionListLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        sectionNameList.setLayoutManager(sectionNameListLayoutManager);
        sectionNameList.setAdapter(sectionNameAdapter);
        sectionList.setLayoutManager(sectionListLayoutManager);
        sectionList.setAdapter(searchSectionAdapter);
    }

    @Override
    public void onItemClick(int position) {
        sectionListLayoutManager.scrollToPositionWithOffset(position, 0);
        searchSectionAdapter.notifyDataSetChanged();
    }
}
