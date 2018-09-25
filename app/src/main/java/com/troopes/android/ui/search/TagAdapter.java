package com.troopes.android.ui.search;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;
import com.troopes.android.data.model.Tag;

import java.util.ArrayList;

public class TagAdapter extends BaseAdapter<TagHolder> {

    private ArrayList<Tag> data = new ArrayList<>();

    @NonNull
    @Override
    public TagHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tag_holder, parent, false);
        return new TagHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TagHolder holder, int position) {
        holder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(ArrayList<Tag> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
