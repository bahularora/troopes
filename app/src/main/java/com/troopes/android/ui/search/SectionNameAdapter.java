package com.troopes.android.ui.search;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;
import com.troopes.android.common.BaseViewHolder;
import com.troopes.android.data.model.Search;

import java.util.ArrayList;


public class SectionNameAdapter extends BaseAdapter<SectionNameHolder> implements BaseViewHolder.OnViewHolderClickListener {

    private ArrayList<Search> data = new ArrayList<>();

    private OnItemClickListener onItemClickListener;

    @NonNull
    @Override
    public SectionNameHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_section_name_item, viewGroup, false);
        return new SectionNameHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SectionNameHolder searchTabHolder, int position) {
        searchTabHolder.bindData(data.get(position));
        searchTabHolder.setOnViewHolderClick(this);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setSearchItemList(ArrayList<Search> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onViewHolderClick(RecyclerView.ViewHolder viewHolder) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(viewHolder.getAdapterPosition());
        }
    }
}