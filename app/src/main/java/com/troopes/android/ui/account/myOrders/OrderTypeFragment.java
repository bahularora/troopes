package com.troopes.android.ui.account.myOrders;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.data.constants.ORDER_STATUS;
import com.troopes.android.data.modelDummy.Order;
import com.troopes.android.viewmodel.MainViewModel;

import java.util.ArrayList;

import butterknife.BindView;

public class OrderTypeFragment extends BaseFragment {

    private static final String ARG_ORDER_TYPE = "order_type";

    @BindView(R.id.order_list)
    RecyclerView orderList;
    @BindView(R.id.no_orders)
    ConstraintLayout noOrderLayout;
    @BindView(R.id.see_items)
    Button seeItems;

    private String orderType;
    private LinearLayoutManager llm;
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
        llm = new LinearLayoutManager(view.getContext());


        switch (orderType) {
            case "all":
                setupOrderScreen(orders);
                break;
            case "pending": {
                ArrayList<Order> temp = new ArrayList<>();
                for (int i = 0; i < orders.size(); i++) {
                    Order order = orders.get(i);
                    if (order.orderStatus == ORDER_STATUS.IN_PROCESS || order.orderStatus == ORDER_STATUS.PENDING) {
                        temp.add(order);
                    }
                }
                setupOrderScreen(temp);
                break;
            }
            case "delivered": {
                ArrayList<Order> temp = new ArrayList<>();
                for (int i = 0; i < orders.size(); i++) {
                    Order order = orders.get(i);
                    if (order.orderStatus == ORDER_STATUS.DELIVERED) {
                        temp.add(order);
                    }
                }
                setupOrderScreen(temp);
                break;
            }
            case "cancelled": {
                ArrayList<Order> temp = new ArrayList<>();
                for (int i = 0; i < orders.size(); i++) {
                    Order order = orders.get(i);
                    if (order.orderStatus == ORDER_STATUS.CANCELLED) {
                        temp.add(order);
                    }
                }
                setupOrderScreen(temp);
                break;
            }
        }


    }

    private void setupOrderScreen(ArrayList<Order> orders) {
        if (orders.size() == 0 || orders == null) {
            orderList.setVisibility(View.GONE);
            noOrderLayout.setVisibility(View.VISIBLE);

            seeItems.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // do something
                }
            });
        } else {
            noOrderLayout.setVisibility(View.GONE);
            orderList.setVisibility(View.VISIBLE);

            llm.setOrientation(LinearLayoutManager.VERTICAL);
            orderAdapter.setData(orders);

            orderList.setAdapter(orderAdapter);
            orderList.setLayoutManager(llm);
        }

    }
}
