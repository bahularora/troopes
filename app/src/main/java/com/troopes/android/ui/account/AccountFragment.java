package com.troopes.android.ui.account;


import android.view.View;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;

public class AccountFragment extends BaseFragment {
    public static AccountFragment newInstance() {
        return new AccountFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.account_fragment;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return 0;
    }

    @Override
    protected void init(View view) {
        super.init(view);
    }
}
