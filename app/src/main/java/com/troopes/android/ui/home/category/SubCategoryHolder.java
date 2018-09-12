package com.troopes.android.ui.home.category;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.troopes.android.R;
import com.troopes.android.common.BaseViewHolder;
import com.troopes.android.data.model.SubCategory;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubCategoryHolder extends BaseViewHolder {

    @BindView(R.id.sub_category_image)
    ImageView image;
    @BindView(R.id.sub_category_text)
    TextView text;


    public SubCategoryHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(SubCategory subCategory) {
        // TODO: Get image from url
        Glide.with(itemView.getContext())
                .load(ContextCompat.getDrawable(itemView.getContext(), R.drawable.sample_sub_category))
                .into(image);
        text.setText(subCategory.name);
    }

}
