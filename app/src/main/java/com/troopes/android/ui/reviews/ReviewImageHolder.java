package com.troopes.android.ui.reviews;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.troopes.android.R;
import com.troopes.android.common.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewImageHolder extends BaseViewHolder {

    @BindView(R.id.review_image_holder)
    ImageView imageView;

    public ReviewImageHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(String imageUrl) {
        Picasso.get().load(imageUrl).fit().centerCrop().into(imageView);
    }
}
