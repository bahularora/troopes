package com.troopes.android.ui.home.category;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;
import com.troopes.android.data.model.SubCategory;

import java.util.ArrayList;

public class SubCategoryAdapter extends BaseAdapter<SubCategoryHolder> {

    private ArrayList<SubCategory> subCategories = new ArrayList<>();

    @NonNull
    @Override
    public SubCategoryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sub_category_holder, viewGroup, false);
        return new SubCategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubCategoryHolder subCategoryHolder, int position) {
        subCategoryHolder.bindData(subCategories.get(position));
    }

    @Override
    public int getItemCount() {
        return subCategories.size();
    }

    public void setSubCategories(ArrayList<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
