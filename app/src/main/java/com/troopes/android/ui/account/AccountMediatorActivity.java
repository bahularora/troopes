package com.troopes.android.ui.account;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.troopes.android.R;
import com.troopes.android.common.BaseActivity;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.ui.account.address.AddressFragment;
import com.troopes.android.ui.account.myOrders.MyOrdersFragment;
import com.troopes.android.ui.account.wishlist.WishlistFragment;
import com.troopes.android.ui.order.AddAddressFragment;
import com.troopes.android.ui.order.OrderSetAddressFragment;
import com.troopes.android.utils.ToolbarUtils;

import java.util.List;

public class AccountMediatorActivity extends BaseActivity implements BaseFragment.OnFragmentInteractionListener {

    private static final String ARG_ACC_SCREEN = "account_screen";
    private String screenName = null;

    @Override
    protected int getLayoutResId() {
        return R.layout.account_mediator_activity;
    }

    @Override
    protected void setToolbar(Fragment fragment) {
        if (fragment.getClass().getSimpleName().equals(WishlistFragment.class.getSimpleName())) {
            ToolbarUtils.setBackgroundColor(AccountMediatorActivity.this, R.color.colorAppMain);
            ToolbarUtils.setupSimpleToolbar(AccountMediatorActivity.this, "Wishlist", R.color._white);
        } else if (fragment.getClass().getSimpleName().equals(MyOrdersFragment.class.getSimpleName())) {
            ToolbarUtils.setBackgroundColor(AccountMediatorActivity.this, R.color.colorAppMain);
            ToolbarUtils.setupSimpleToolbar(AccountMediatorActivity.this, "My Orders", R.color._white);
        } else if (fragment.getClass().getSimpleName().equals(MyProfileFragment.class.getSimpleName())) {
            ToolbarUtils.setBackgroundColor(AccountMediatorActivity.this, R.color.colorAppMain);
            ToolbarUtils.setupSimpleToolbar(AccountMediatorActivity.this, "My Profile", R.color._white);
        } else if (fragment.getClass().getSimpleName().equals(AddressFragment.class.getSimpleName())) {
            ToolbarUtils.setBackgroundColor(AccountMediatorActivity.this, R.color.colorAppMain);
            ToolbarUtils.setupSimpleToolbar(AccountMediatorActivity.this, "Address", R.color._white);
        } else if (fragment.getClass().getSimpleName().equals(AddAddressFragment.class.getSimpleName())) {
            ToolbarUtils.setBackgroundColor(AccountMediatorActivity.this, R.color.colorAppMain);
            ToolbarUtils.setupSimpleToolbar(AccountMediatorActivity.this, "Add a Address", R.color._white);
        } else if (fragment.getClass().getSimpleName().equals(AccountSettingFragment.class.getSimpleName())) {
            ToolbarUtils.setBackgroundColor(AccountMediatorActivity.this, R.color.colorAppMain);
            ToolbarUtils.setupSimpleToolbar(AccountMediatorActivity.this, "Account Settings", R.color._white);
        } else if (fragment.getClass().getSimpleName().equals(OrderSetAddressFragment.class.getSimpleName())) {
            ToolbarUtils.setBackgroundColor(AccountMediatorActivity.this, R.color.colorAppMain);
            ToolbarUtils.setupSimpleToolbar(AccountMediatorActivity.this, "Address", R.color._white);
        } else {
            ToolbarUtils.hide(AccountMediatorActivity.this);
        }
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

    @Override
    protected void init() {
        super.init();
        if (getIntent() != null) {
            screenName = getIntent().getStringExtra(ARG_ACC_SCREEN);
        }
        setupScreen(screenName);
    }

    private void setupScreen(String screenName) {
        if (screenName == null) {
            // do something

        } else if (screenName.equals("OrderSetAddressFragment")) {
            OrderSetAddressFragment fragment = OrderSetAddressFragment.newInstance();
            fragment.setOnFragmentInteractionListener(this);
            replaceFragment(fragment);
        } else if (screenName.equals("MyOrdersFragment")) {
            replaceFragment(MyOrdersFragment.newInstance());
        } else if (screenName.equals("WishlistFragment")) {
            replaceFragment(WishlistFragment.newInstance());
        } else if (screenName.equals("AccountSettingFragment")) {
            AccountSettingFragment fragment = AccountSettingFragment.newInstance();
            fragment.setOnFragmentInteractionListener(this);
            replaceFragment(fragment);
        } else if (screenName.equals("MyProfileFragment")) {
            replaceFragment(MyProfileFragment.newInstance());
        }
    }

    @Override
    public void onInteraction(Fragment fragment) {
        replaceFragment(fragment);
    }
}
