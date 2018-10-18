package com.troopes.android.ui.order;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.data.modelDummy.product.Product;
import com.troopes.android.ui.product.ProductActivity;
import com.troopes.android.ui.product.gridList.ProductGridListAdapter;
import com.troopes.android.utils.GridSpacingItemDecoration;
import com.troopes.android.viewmodel.ProductViewModel;

import java.util.ArrayList;

import butterknife.BindView;

public class OrderPendingFragment extends BaseFragment implements BaseAdapter.OnItemClickListener {

    private static final String ARG_PRODUCT_ID = "productId";

    @BindView(R.id.time_left_text)
    TextView timeLeftTimer;
    @BindView(R.id.invite_button)
    Button inviteButton;
    @BindView(R.id.product_grid_listing)
    RecyclerView similarProductList;

    private long productId;
    private ProductGridListAdapter similarProductAdapter;

    private ProductViewModel productViewModel;

    public static OrderPendingFragment newInstance(long productId) {
        OrderPendingFragment fragment = new OrderPendingFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_PRODUCT_ID, productId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.order_pending_fragment;
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
        similarProductAdapter = new ProductGridListAdapter();

        ViewCompat.setNestedScrollingEnabled(similarProductList, false);

        ArrayList<Product> similarProducts = productViewModel.getSimilarProductList(productId);

        similarProductAdapter.setProductList(similarProducts);

        similarProductAdapter.setOnItemClickListener(this);
        similarProductList.setAdapter(similarProductAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 2);
        similarProductList.addItemDecoration(new GridSpacingItemDecoration(2, 6, true));
        similarProductList.setLayoutManager(gridLayoutManager);

    }

    @Override
    public void onItemClick(int position, String name) {
        long similarItemProductId = productViewModel.getSimilarProductList(productId).get(position).productId;
        Intent intent = new Intent(getActivity(), ProductActivity.class);
        intent.putExtra(ARG_PRODUCT_ID, similarItemProductId);
        startActivity(intent);
    }
}
