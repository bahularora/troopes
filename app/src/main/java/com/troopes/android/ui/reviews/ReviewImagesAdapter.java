package com.troopes.android.ui.reviews;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class ReviewImagesAdapter extends BaseAdapter<ReviewImageHolder> {

    List<String> imagesUrl = new ArrayList<>();

    @NonNull
    @Override
    public ReviewImageHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.review_image_holder, viewGroup, false);
        return new ReviewImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewImageHolder reviewImageHolder, int position) {
        reviewImageHolder.bindData(imagesUrl.get(position));
    }

    @Override
    public int getItemCount() {
        return imagesUrl.size();
    }

    public void setReviewImagesUrl(List<String> imagesUrl) {
        this.imagesUrl = imagesUrl;
        notifyDataSetChanged();
    }
}