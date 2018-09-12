package com.troopes.android;

import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.troopes.android.common.BaseActivity;
import com.troopes.android.ui.home.HomeFragment;
import com.troopes.android.viewmodel.MainViewModel;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    private MainViewModel mainViewModel;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {
        super.init();
        hideToolbar();

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

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
