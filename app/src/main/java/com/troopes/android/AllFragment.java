package com.troopes.android;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

public class AllFragment extends BaseFragment {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_all;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return R.id.progress_bar;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
