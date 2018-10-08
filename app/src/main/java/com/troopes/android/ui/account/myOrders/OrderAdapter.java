package com.troopes.android.ui.account.myOrders;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;
import com.troopes.android.data.model.Order;

import java.util.ArrayList;

public class OrderAdapter extends BaseAdapter<OrderHolder> {

    ArrayList<Order> data = new ArrayList<>();

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_holder, parent, false);
        return new OrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {
        holder.bindData(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(ArrayList<Order> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
