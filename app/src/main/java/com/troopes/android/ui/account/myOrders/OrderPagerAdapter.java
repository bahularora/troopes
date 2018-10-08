package com.troopes.android.ui.account.myOrders;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class OrderPagerAdapter extends FragmentPagerAdapter {

    public OrderPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        String type = "";
        if (position == 0) {
            type = "all";
        } else if (position == 1) {
            type = "pending";
        } else if (position == 2) {
            type = "delivered";
        } else if (position == 3) {
            type = "cancelled";
        }
        return OrderTypeFragment.newInstance(type);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
