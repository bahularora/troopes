package com.troopes.android.ui.product.productOption;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.R;
import com.troopes.android.data.modelDummy.product.Variant;

import java.util.ArrayList;

public class VariantAdapter extends RecyclerView.Adapter<VariantHolder> {

    private ArrayList<Variant> data = new ArrayList<>();

    @NonNull
    @Override
    public VariantHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_option_variant_holder, viewGroup, false);
        return new VariantHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VariantHolder variantHolder, int position) {
        variantHolder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(ArrayList<Variant> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}