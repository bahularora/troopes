package com.troopes.android.common;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.troopes.android.R;

import java.util.List;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        init();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @LayoutRes
    protected abstract int getLayoutResId();

    protected void init() {}

    protected void showToolbar(String message, boolean backButton) {
        if(getSupportActionBar()!=null) {
            getSupportActionBar().show();
            getSupportActionBar().setTitle(message);
            getSupportActionBar().setDisplayHomeAsUpEnabled(backButton);
        }
    }

    protected void hideToolbar() {
        if(getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }
    }

    protected void replaceFragment(Fragment fragment) {
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
        String tag = fragment.getClass().getName();
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
