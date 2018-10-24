package com.troopes.android.ui.product;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.troopes.android.R;
import com.troopes.android.common.BaseActivity;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.ui.reviews.ReviewsFragment;
import com.troopes.android.ui.reviews.writeReview.WriteReviewFragment;
import com.troopes.android.utils.ToolbarUtils;
import com.troopes.android.viewmodel.ProductViewModel;

import java.util.List;

public class ProductActivity extends BaseActivity implements BaseFragment.OnFragmentInteractionListener {

    private static final String ARG_PRODUCT_ID = "productId";
    private long productId;
    private int fragmentCount = 0;

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
    public void onBackPressed() {
        if (fragmentCount-- > 0) {
            Log.i("ProductAct", fragmentCount + "");
            replaceFragment(ProductFragment.newInstance(productId));
        } else {
            finish();
        }

    }

    @Override
    protected void setToolbar(Fragment fragment) {
        if (fragment.getClass().getName().equals(ReviewsFragment.class.getName())) {
            ToolbarUtils.setBackgroundColor(ProductActivity.this, R.color.colorAppMain);
            ToolbarUtils.setupSimpleToolbar(ProductActivity.this, "Reviews", R.color._white);
        } else if (fragment.getClass().getName().equals(WriteReviewFragment.class.getName())) {
            ToolbarUtils.setBackgroundColor(ProductActivity.this, R.color.colorAppMain);
            ToolbarUtils.setupSimpleToolbar(ProductActivity.this, "Write a Review", R.color._white);
        } else if (fragment.getClass().getName().equals(ProductFragment.class.getName())) {
            ToolbarUtils.show(this);
            ToolbarUtils.setBackgroundColor(ProductActivity.this, R.color.colorAppMain);
            ToolbarUtils.changeBackButtonIcon(ProductActivity.this,
                    ContextCompat.getDrawable(ProductActivity.this, R.drawable.ic_back_arrow_24dp));
            ToolbarUtils.hideSearchBar(this);
        }
    }

    @Override
    public void onInteraction(Fragment fragment) {
        fragmentCount++;
        replaceFragment(fragment);
    }

    void replaceFragment(Fragment fragment) {
        setToolbar(fragment);
        String tag = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        List<Fragment> fragments = manager.getFragments();
        if (fragments != null) {
            for (Fragment f : fragments) {
                if (f != null) {
                    transaction.hide(f);
                }
            }
        }
        Fragment f = manager.findFragmentByTag(tag);
        if (f == null) {
            f = fragment;
            transaction.add(R.id.container, f, tag);
        } else {
            transaction.show(f);
        }
        try {
            transaction.commit();
        } catch (IllegalStateException e) {

        } catch (Exception e) {

        }
    }
}
