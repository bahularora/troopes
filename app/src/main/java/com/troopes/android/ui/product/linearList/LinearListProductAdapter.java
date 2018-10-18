package com.troopes.android.ui.product.linearList;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;
import com.troopes.android.common.BaseViewHolder;
import com.troopes.android.data.modelDummy.product.Product;

import java.util.ArrayList;

public class LinearListProductAdapter extends BaseAdapter<LinearListProductHolder> implements BaseViewHolder.OnViewHolderClickListener {

    private ArrayList<Product> data = new ArrayList<>();

    private OnItemClickListener onItemClickListener;

    @NonNull
    @Override
    public LinearListProductHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.holder_product, viewGroup, false);
        return new LinearListProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LinearListProductHolder productHolder, int position) {
        productHolder.bindData(data.get(position));
        productHolder.setOnViewHolderClick(this);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setProductListData(ArrayList<Product> data) {
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
            onItemClickListener.onItemClick(viewHolder.getAdapterPosition(), "");
        }
    }
}
