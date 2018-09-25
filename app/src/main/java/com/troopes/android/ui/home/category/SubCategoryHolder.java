package com.troopes.android.ui.home.category;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
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
        Picasso.get().load(subCategory.url).fit().into(image);
        text.setText(subCategory.name);
    }

}
