package com.troopes.android.ui.product.productOption;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;
import com.troopes.android.data.model.product.Color;

import java.util.ArrayList;

public class ColorAdapter extends BaseAdapter<ColorHolder> {

    private ArrayList<Color> data = new ArrayList<>();

    @NonNull
    @Override
    public ColorHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_option_color_holder, viewGroup, false);
        return new ColorHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorHolder colorHolder, int position) {
        colorHolder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(ArrayList<Color> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
