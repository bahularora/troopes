package com.troopes.android.ui.search;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;
import com.troopes.android.data.modelDummy.Search;

import java.util.ArrayList;

public class SectionAdapter extends BaseAdapter<SectionHolder> {

    private ArrayList<Search> data = new ArrayList<>();

    @NonNull
    @Override
    public SectionHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_section_item, viewGroup, false);
        return new SectionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SectionHolder sectionHolder, int position) {
        sectionHolder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(ArrayList<Search> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}