package com.troopes.android.ui.product.gridList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;
import com.troopes.android.common.BaseViewHolder;
import com.troopes.android.data.model.Product;

import java.util.ArrayList;

public class ProductGridListAdapter extends BaseAdapter<GridListProductHolder> implements BaseViewHolder.OnViewHolderClickListener {

    private ArrayList<Product> data = getSampleData();
    private OnItemClickListener onItemClickListener;

    @NonNull
    @Override
    public GridListProductHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_grid_list_product_holder, viewGroup, false);
        return new GridListProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridListProductHolder gridListProductHolder, int position) {
        gridListProductHolder.bindData(data.get(position));
        gridListProductHolder.setOnViewHolderClick(this);
    }

    @Override
    public int getItemCount() {
        return data.size();
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