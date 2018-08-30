package com.troopes.android;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {
        super.init();
        hideToolbar();
        replaceFragment(new HomeFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        replaceFragment(new HomeFragment());
                        break;
                    case R.id.search:
                        replaceFragment(new HomeFragment());
                        break;
                    case R.id.account:
                        replaceFragment(new HomeFragment());
                        break;
                }
                return true;
            }
        });
    }
}
