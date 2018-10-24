package com.troopes.android.ui.reviews.writeReview;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class ReviewImagesSmallAdapter extends BaseAdapter<ReviewImagesSmallHolder> {

    private ArrayList<String> data = new ArrayList<>();

    @NonNull
    @Override
    public ReviewImagesSmallHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.review_image_holder_small, viewGroup, false);
        return new ReviewImagesSmallHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewImagesSmallHolder reviewImagesSmallHolder, int position) {
        reviewImagesSmallHolder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setReviewImagesUrl(List<String> data) {
        this.data.addAll(data);
        // TODO use notify range
        notifyDataSetChanged();
    }
}
