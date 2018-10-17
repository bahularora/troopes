package com.troopes.android.ui.reviews;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.troopes.android.R;
import com.troopes.android.common.BaseViewHolder;
import com.troopes.android.data.modelDummy.Review;
import com.troopes.android.utils.ExpandableTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ReviewHolder extends BaseViewHolder {

    @BindView(R.id.profile_image)
    CircleImageView profileImage;
    @BindView(R.id.profile_name)
    TextView profileName;
    @BindView(R.id.review_date)
    TextView reviewDate;
    @BindView(R.id.rating_bar)
    RatingBar reviewRating;
    @BindView(R.id.product_variant)
    TextView productVariant;
    @BindView(R.id.product_size)
    TextView productSize;
    @BindView(R.id.product_color)
    TextView productColor;
    @BindView(R.id.review_product_images)
    RecyclerView reviewImages;
    @BindView(R.id.review_content)
    ExpandableTextView reviewContent;

    private ReviewImagesAdapter adapter;

    public ReviewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(Review review) {
        Picasso.get().load(review.profileImageUrl).fit().centerCrop().into(profileImage);
        profileName.setText(review.profileName);
        reviewDate.setText(review.reviewDate);
        // allow listener for rating change if profile/ review belong to user
        // show the review fragment and from there allow editing information
        reviewRating.setRating(review.rating);
        productVariant.setText(review.productVariant);
        productColor.setText(review.productColor);
        productSize.setText(review.productSize);
        reviewContent.setText(review.review);

        LinearLayoutManager reviewImagesLayoutManager = new LinearLayoutManager(itemView.getContext());
        reviewImagesLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        adapter = new ReviewImagesAdapter();
        adapter.setReviewImagesUrl(review.reviewImagesUrl);
        reviewImages.setAdapter(adapter);
        reviewImages.setLayoutManager(reviewImagesLayoutManager);

    }
}