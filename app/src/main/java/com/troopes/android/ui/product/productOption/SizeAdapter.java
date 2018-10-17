package com.troopes.android.ui.product.productOption;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;
import com.troopes.android.data.modelDummy.product.Size;

import java.util.ArrayList;

public class SizeAdapter extends BaseAdapter<SizeHolder> {

    private ArrayList<Size> data = new ArrayList<>();

    @NonNull
    @Override
    public SizeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_option_size_holder, viewGroup, false);
        return new SizeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SizeHolder sizeHolder, int i) {
        sizeHolder.bindData(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(ArrayList<Size> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
