package com.troopes.android.common;

import android.support.v7.widget.RecyclerView;

public abstract class BaseAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    protected void setOnItemClickListener(OnItemClickListener onItemClickListener) {
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
