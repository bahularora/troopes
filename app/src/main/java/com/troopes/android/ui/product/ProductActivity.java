package com.troopes.android.ui.product;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.troopes.android.R;
import com.troopes.android.common.BaseActivity;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.ui.reviews.ReviewsFragment;
import com.troopes.android.utils.ToolbarUtils;
import com.troopes.android.viewmodel.ProductViewModel;

public class ProductActivity extends BaseActivity implements BaseFragment.OnFragmentInteractionListener {

    private static final String ARG_PRODUCT_ID = "productId";
    private long productId;

    private ProductViewModel productViewModel;

    @Override
    protected int getLayoutResId() {
        return R.layout.product_activity;
    }

    @Override
    protected void init() {
        super.init();
        if (getIntent() != null) {
            productId = getIntent().getLongExtra(ARG_PRODUCT_ID, 0);
        }
        ProductFragment fragment = ProductFragment.newInstance(productId);
        fragment.setOnFragmentInteractionListener(this);
        replaceFragment(fragment);
        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);

    }

    @Override
    protected void setToolbar(Fragment fragment) {
        if (fragment.getClass().getSimpleName().equals(ReviewsFragment.class.getSimpleName())) {
            ToolbarUtils.setupSimpleToolbar(ProductActivity.this, "Reviews", R.color._white);
        } else if (fragment.getClass().getSimpleName().equals(ProductFragment.class.getSimpleName())) {
            ToolbarUtils.show(this);
            ToolbarUtils.changeBackButtonIcon(ProductActivity.this,
                    ContextCompat.getDrawable(ProductActivity.this, R.drawable.ic_back_arrow_24dp));
            ToolbarUtils.hideSearchBar(this);
        }
    }

    @Override
    public void onInteraction(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, fragment.getClass().getSimpleName()).commit();
        // need to explicitly call setToolbar as not using replaceFragment()
        setToolbar(fragment);
    }
}
