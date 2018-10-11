package com.troopes.android.common;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.troopes.android.BuildConfig;
import com.troopes.android.R;
import com.troopes.android.ui.home.all.AllFragment;

import java.util.List;
import java.util.Stack;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    Stack<String> fragStack = new Stack<>();

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
                //onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @LayoutRes
    protected abstract int getLayoutResId();

    protected void init() {
    }

    protected void setToolbar(Fragment fragment) {
    }

    protected void replaceFragment(Fragment fragment) {
        replaceFragment(fragment, true);
    }

    protected void replaceFragment(Fragment fragment, boolean addTag) {
        if (BuildConfig.DEBUG)
            Log.i("onBackPressed", " -- " + fragment.getClass().getName() + " added ");
        setToolbar(fragment);
        String tag = fragment.getClass().getName();
        if (addTag)
            fragStack.push(tag);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        // hiding all available fragments - used as we are using transaction.add() instead of replace
        // if we don't do this it will result in fragments coming on top of each other
        List<Fragment> fragments = manager.getFragments();
        if (fragments != null) {
            for (Fragment f : fragments) {
                if (f != null) {
                    transaction.hide(f);
                }
            }
        }
        // get the fragment by tag if available
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

    protected void replaceFragmentByTag(String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        // hiding all available fragments
        List<Fragment> fragments = manager.getFragments();
        if (fragments != null) {
            for (Fragment f : fragments) {
                if (f != null) {
                    transaction.hide(f);
                }
            }
        }
        // get the fragment by tag if available
        Fragment f = manager.findFragmentByTag(tag);
        if (f == null) {
            Log.i("onBackPressed", " fragment is null ");
            // What to do here???
            //f = fragment;
            //transaction.add(R.id.container, f, tag);
        } else {
            setToolbar(f);
            Log.i("onBackPressed", tag + " is present in backstack ");
            transaction.show(f);
        }
        try {
            transaction.commit();
        } catch (IllegalStateException e) {

        } catch (Exception e) {

        }
    }

    protected String popTag(int count) {
        String tag = null;
        while (count > 0) {
            String temp = fragStack.pop();
            if (BuildConfig.DEBUG)
                Log.i("onBackPressed - popping", "-- " + temp);
            count--;
        }
        tag = fragStack.peek();

        if (fragStack.empty()) { // and only if activity instance of MainActivity
            replaceFragment(new AllFragment());
            return null;
        }

        return tag;
    }

    protected String getCurrentFragmentTag() {
        return fragStack.peek();
    }

    // problems - what if we skip multiple fragment by opening other fragment like from Add Address screen
    // click on any item on Bottom nav eg search, so on back press we don't want to go back to add address screen
}
