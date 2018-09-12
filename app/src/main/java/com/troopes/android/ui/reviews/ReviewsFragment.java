package com.troopes.android.ui.reviews;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.troopes.android.R;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.viewmodel.ProductViewModel;

import butterknife.BindView;

public class ReviewsFragment extends BaseFragment {

    private static final String ARG_PRODUCT_ID = "productId";
    @BindView(R.id.reviews_list)
    RecyclerView reviewList;
    ReviewAdapter adapter;
    private long productId;
    private ProductViewModel productViewModel;

    public static ReviewsFragment newInstance(long productId) {
        ReviewsFragment fragment = new ReviewsFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_PRODUCT_ID, productId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.reviews_fragment;
    }

    @Override
    protected int getProgressBarLayoutId() {
        return 0;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        if (getActivity() == null) {
            return;
        }
        if (getArguments() != null) {
            productId = getArguments().getLong(ARG_PRODUCT_ID);
        }
        productViewModel = ViewModelProviders.of(getActivity()).get(ProductViewModel.class);

        adapter = new ReviewAdapter();
        adapter.setReviews(productViewModel.getReviews());
        reviewList.setAdapter(adapter);

        LinearLayoutManager reviewLayoutManager = new LinearLayoutManager(view.getContext());
        reviewLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        reviewList.setLayoutManager(reviewLayoutManager);
    }
}
