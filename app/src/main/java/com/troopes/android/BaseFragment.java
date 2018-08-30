package com.troopes.android;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    private ProgressBar progressBar;

    @LayoutRes
    abstract protected int getLayoutResId();

    abstract protected int getProgressBarLayoutId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = view.findViewById(getProgressBarLayoutId());
        init(view);
    }

    protected void init(View view) {}

    protected void showProgressBar() {
        if(progressBar!=null) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    protected void hideProgressBar() {
        if(progressBar!=null) {
            progressBar.setVisibility(View.GONE);
        }
    }
}
