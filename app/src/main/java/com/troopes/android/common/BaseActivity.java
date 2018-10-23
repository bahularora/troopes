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

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

//    List<String> fragStack = new ArrayList<>();

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

//    protected String popTag(int count) {
//        String tag = null;
//        while (count > 0) {
//            String temp = fragStack.pop();
//            if (BuildConfig.DEBUG)
//                Log.i("onBackPressed - popping", "-- " + temp);
//            count--;
//        }
//        tag = fragStack.peek();
//
//        if (fragStack.size() == 0) { // and only if activity instance of MainActivity
//            replaceFragment(new AllFragment());
//            return null;
//        }
//        return tag;
//    }
//
//    protected String getCurrentFragmentTag() {
//        return fragStack.peek();
//    }

    // problems - what if we skip multiple fragment by opening other fragment like from Add Address screen
    // click on any item on Bottom nav eg search, so on back press we don't want to go back to add address screen
}
