package com.troopes.android.ui.home.all;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.troopes.android.R;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {

    private ArrayList<Integer> images;

    public BannerAdapter(ArrayList<Integer> images) {
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(container.getContext());
        View imageLayout = layoutInflater.inflate(R.layout.layout_banner, container, false);
        if (imageLayout != null) {
            ImageView currBannerImage = imageLayout.findViewById(R.id.banner_image);
            currBannerImage.setImageResource(images.get(position));
        }
        container.addView(imageLayout);
        return imageLayout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
