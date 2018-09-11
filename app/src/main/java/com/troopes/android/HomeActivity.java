package com.troopes.android;

import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.troopes.android.common.BaseActivity;
import com.troopes.android.ui.home.HomeFragment;
import com.troopes.android.ui.product.ProductFragment;
import com.troopes.android.ui.product.productOption.ProductOptionFragment;
import com.troopes.android.viewmodel.AllProductListViewModel;
import com.troopes.android.viewmodel.CategoryViewModel;
import com.troopes.android.viewmodel.ProductViewModel;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    private AllProductListViewModel allProductListViewModel;
    private CategoryViewModel categoryViewModel;
    private ProductViewModel productViewModel

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_home;
    }

    @Override
    protected void init() {
        super.init();
        hideToolbar();

        allProductListViewModel = ViewModelProviders.of(this).get(AllProductListViewModel.class);
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel.class);
        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);

        replaceFragment(new HomeFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        replaceFragment(new HomeFragment());
                        break;
                    case R.id.search:
                        replaceFragment(ProductFragment.newInstance(101);
                        break;
                    case R.id.account:
                        replaceFragment(ProductOptionFragment.newInstance(101));
                        break;
                }
                return true;
            }
        });
    }
}
