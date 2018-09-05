package com.troopes.android.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.troopes.android.ui.home.all.AllFragment;
import com.troopes.android.ui.home.category.CategoryFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AllFragment();
        } else {
            return CategoryFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 12;
    }
}
