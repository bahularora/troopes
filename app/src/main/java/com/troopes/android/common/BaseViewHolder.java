package com.troopes.android.common;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    protected void setOnViewHolderClick(OnViewHolderClickListener onViewHolderClickListener) {
    }

    public interface OnViewHolderClickListener {
        void onViewHolderClick(RecyclerView.ViewHolder viewHolder);
    }
}
