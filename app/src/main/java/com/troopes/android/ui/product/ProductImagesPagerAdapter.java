package com.troopes.android.ui.product;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.troopes.android.R;

import java.util.ArrayList;

public class ProductImagesPagerAdapter extends PagerAdapter {

    private ArrayList<String> data = new ArrayList<>();

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View imageLayout = LayoutInflater.from(container.getContext())
                .inflate(R.layout.banner_item, container, false);
        if (imageLayout != null) {
            ImageView currBannerImage = imageLayout.findViewById(R.id.banner_image);
            Picasso.get().load(data.get(position)).fit().centerCrop().into(currBannerImage);
        }
        container.addView(imageLayout, 0);
        return imageLayout;
    }


    // override this method so that on url update we remove old url and update images from new urls
    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}