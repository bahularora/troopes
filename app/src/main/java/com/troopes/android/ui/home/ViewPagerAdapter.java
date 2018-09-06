package com.troopes.android.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.troopes.android.ui.home.all.AllFragment;
import com.troopes.android.ui.home.category.CategoryFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private int categoriesCount;

    public ViewPagerAdapter(FragmentManager fm, int categoriesCount) {
        super(fm);
        this.categoriesCount = categoriesCount;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AllFragment();
        } else {
            return CategoryFragment.newInstance(position - 1);
        }
    }

    @Override
    public int getCount() {
        // + 1 for all fragment screen
        return categoriesCount + 1;
    }
}
