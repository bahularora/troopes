package com.troopes.android.ui.reviews.writeReview;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.troopes.android.R;
import com.troopes.android.common.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewImagesSmallHolder extends BaseViewHolder {
    @BindView(R.id.review_image_holder_small)
    ImageView imageView;

    public ReviewImagesSmallHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(String imageUrl) {
        // TODO implement close button
        Picasso.get().load(imageUrl).fit().centerCrop().into(imageView);
    }
}
