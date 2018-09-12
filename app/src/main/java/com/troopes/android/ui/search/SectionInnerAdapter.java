package com.troopes.android.ui.search;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;
import com.troopes.android.data.model.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class SectionInnerAdapter extends BaseAdapter<SectionInnerHolder> {

    private List<SubCategory> data = new ArrayList<>();

    @NonNull
    @Override
    public SectionInnerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_section_inner_item, viewGroup, false);
        return new SectionInnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SectionInnerHolder sectionInnerHolder, int position) {
        sectionInnerHolder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<SubCategory> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
