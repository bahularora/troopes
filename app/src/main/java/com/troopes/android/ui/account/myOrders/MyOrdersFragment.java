package com.troopes.android.ui.account.myOrders;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;

import butterknife.BindView;

public class MyOrdersFragment extends BaseFragment {

    @BindView(R.id.top_tab_layout)
    SmartTabLayout smartTabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    public static MyOrdersFragment newInstance() {
        return new MyOrdersFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.my_orders_fragment;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return 0;
    }

    @Override
    protected void init(View view) {
        super.init(view);

        viewPager.setAdapter(new OrderPagerAdapter(getChildFragmentManager()));
        smartTabLayout.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                View view1 = LayoutInflater.from(smartTabLayout.getContext()).inflate(R.layout.order_tab, container, false);
                TextView textView = view1.findViewById(R.id.tab_text);
                if (position == 0) {
                    textView.setText("All");
                } else if (position == 1) {
                    textView.setText("Pending");
                } else if (position == 2) {
                    textView.setText("Delivered");
                } else if (position == 3) {
                    textView.setText("Cancelled");
                }
                return view1;
            }
        });
        smartTabLayout.setViewPager(viewPager);
    }
}
