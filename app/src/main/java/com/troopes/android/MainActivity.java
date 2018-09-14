package com.troopes.android;

import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.troopes.android.common.BaseActivity;
import com.troopes.android.ui.account.AccountFragment;
import com.troopes.android.ui.home.HomeFragment;
import com.troopes.android.ui.search.SearchFragment;
import com.troopes.android.utils.ToolbarUtils;
import com.troopes.android.viewmodel.MainViewModel;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.search_container)
    LinearLayout searchContainer;

    private MainViewModel mainViewModel;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setToolbar(Fragment fragment) {
        if (fragment.getClass().getSimpleName().equals(HomeFragment.class.getSimpleName())) {
            ToolbarUtils.hide(MainActivity.this);
        } else if (fragment.getClass().getSimpleName().equals(SearchFragment.class.getSimpleName())) {
            ToolbarUtils.show(MainActivity.this);
            ToolbarUtils.hideToolbar(MainActivity.this);
            ToolbarUtils.showSearchBar(MainActivity.this);
        } else if (fragment.getClass().getSimpleName().equals(AccountFragment.class.getSimpleName())) {
            ToolbarUtils.show(MainActivity.this);
            ToolbarUtils.hideSearchBar(MainActivity.this);
            ToolbarUtils.showToolbar(MainActivity.this);
            ToolbarUtils.hideShare(MainActivity.this);
            ToolbarUtils.hideBackButton(MainActivity.this);
            ToolbarUtils.hideFavourite(MainActivity.this);
            ToolbarUtils.setToolbarTitle(MainActivity.this, "Accounts");
        } else {
            ToolbarUtils.hide(this);
        }
    }

    @Override
    protected void init() {
        super.init();

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        replaceFragment(new HomeFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        replaceFragment(HomeFragment.newInstance());
                        break;
                    case R.id.search:
                        replaceFragment(SearchFragment.newInstance(false));
                        break;
                    case R.id.account:
                        replaceFragment(AccountFragment.newInstance());
                        break;
                }
                return true;
            }
        });

        searchContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fragment fragment = SearchFragment.newInstance(true);
                // replaceFragment method not working due to problem that trendingScreen and SearchScreen both have same Tag
                // Why is the replaceFragment method not working here
                // replaceFragment(SearchFragment.newInstance(true));
                Fragment fragment = SearchFragment.newInstance(true);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, fragment, fragment.getClass().getSimpleName())
                        .commit();
                setToolbar(fragment);
            }
        });
    }
}
