package com.troopes.android.ui.account.wishlist;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;
import com.troopes.android.data.modelDummy.Wishlist;

import java.util.ArrayList;

public class WishlistAdapter extends BaseAdapter<WishlistHolder> {

    ArrayList<Wishlist> data = new ArrayList<>();

    @NonNull
    @Override
    public WishlistHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlist_holder, parent, false);
        return new WishlistHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WishlistHolder holder, int position) {
        holder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(ArrayList<Wishlist> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
