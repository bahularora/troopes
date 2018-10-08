package com.troopes.android.ui.account.myOrders;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.data.constants.ORDER_STATUS;
import com.troopes.android.data.model.Order;
import com.troopes.android.viewmodel.MainViewModel;

import java.util.ArrayList;

import butterknife.BindView;

public class OrderTypeFragment extends BaseFragment {

    private static final String ARG_ORDER_TYPE = "order_type";
    @BindView(R.id.order_list)
    RecyclerView orderList;
    private String orderType;
    private OrderAdapter orderAdapter;

    private MainViewModel mainViewModel;

    public static OrderTypeFragment newInstance(String orderType) {
        OrderTypeFragment fragment = new OrderTypeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ORDER_TYPE, orderType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.order_type_fragment;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return 0;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        if (getActivity() == null) {
            return;
        }
        if (getArguments() != null) {
            orderType = getArguments().getString(ARG_ORDER_TYPE);
        }

        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        ArrayList<Order> orders = mainViewModel.getOrderList();
        orderAdapter = new OrderAdapter();
        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        if (orderType.equals("all")) {
            orderAdapter.setData(orders);
        } else if (orderType.equals("pending")) {
            ArrayList<Order> temp = new ArrayList<>();
            for (int i = 0; i < orders.size(); i++) {
                Order order = orders.get(i);
                if (order.orderStatus == ORDER_STATUS.IN_PROCESS || order.orderStatus == ORDER_STATUS.PENDING) {
                    temp.add(order);
                }
            }
            orderAdapter.setData(temp);
        } else if (orderType.equals("delivered")) {
            ArrayList<Order> temp = new ArrayList<>();
            for (int i = 0; i < orders.size(); i++) {
                Order order = orders.get(i);
                if (order.orderStatus == ORDER_STATUS.DELIVERED) {
                    temp.add(order);
                }
            }
            orderAdapter.setData(temp);
        } else if (orderType.equals("cancelled")) {
            ArrayList<Order> temp = new ArrayList<>();
            for (int i = 0; i < orders.size(); i++) {
                Order order = orders.get(i);
                if (order.orderStatus == ORDER_STATUS.CANCELLED) {
                    temp.add(order);
                }
            }
            orderAdapter.setData(temp);
        }

        orderList.setAdapter(orderAdapter);
        orderList.setLayoutManager(llm);
    }
}
