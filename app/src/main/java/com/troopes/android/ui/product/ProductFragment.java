package com.troopes.android.ui.product;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.troopes.android.R;
import com.troopes.android.common.BaseAdapter;
import com.troopes.android.common.BaseFragment;
import com.troopes.android.data.model.Review;
import com.troopes.android.data.model.product.Product;
import com.troopes.android.ui.product.gridList.ProductGridListAdapter;
import com.troopes.android.ui.product.productOption.VariantAdapter;
import com.troopes.android.ui.reviews.ReviewAdapter;
import com.troopes.android.ui.reviews.ReviewsFragment;
import com.troopes.android.viewmodel.ProductViewModel;

import java.util.ArrayList;

import butterknife.BindView;

public class ProductFragment extends BaseFragment implements BaseAdapter.OnItemClickListener {

    private static final String ARG_PRODUCT_ID = "productId";

    @BindView(R.id.product_viewpager)
    ViewPager productImagePager;
    @BindView(R.id.original_price)
    TextView originalPrice;
    @BindView(R.id.discounted_price)
    TextView discountedPrice;
    @BindView(R.id.sold_times)
    TextView quantitySold;
    @BindView(R.id.product_name)
    TextView productName;
    @BindView(R.id.package_layout)
    LinearLayout packageLayout;
    @BindView(R.id.product_variant_list)
    RecyclerView variantList;
    @BindView(R.id.color_size_container)
    ConstraintLayout colorSizeContainer;
    @BindView(R.id.more_rating_icon)
    ImageView moreRatingButton;
    @BindView(R.id.review_count)
    TextView reviewCount;
    // recent review
    @BindView(R.id.recent_review)
    RecyclerView recentReviewList;
    @BindView(R.id.product_grid_listing)
    RecyclerView similarProductList;

    private long productId;
    private ServiceDescriptionBottomSheet serviceDescriptionBottomSheet;
    private ProductImagesPagerAdapter productImagesPagerAdapter;
    private ProductGridListAdapter similarProductAdapter;
    private VariantAdapter variantAdapter;

    private OnFragmentInteractionListener onFragmentInteractionListener;

    private ProductViewModel productViewModel;

    public static ProductFragment newInstance(long productId) {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_PRODUCT_ID, productId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onFragmentInteractionListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.product_fragment;
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
        productImagesPagerAdapter = new ProductImagesPagerAdapter();
        similarProductAdapter = new ProductGridListAdapter();
        variantAdapter = new VariantAdapter();
        ReviewAdapter recentReviewAdapter = new ReviewAdapter();
        serviceDescriptionBottomSheet = new ServiceDescriptionBottomSheet();

        ViewCompat.setNestedScrollingEnabled(similarProductList, false);
        ViewCompat.setNestedScrollingEnabled(recentReviewList, false);

        Product product = productViewModel.getProduct(productId);
        ArrayList<Product> similarProducts = productViewModel.getSimilarProductList(productId);
        ArrayList<Review> recentReviews = productViewModel.latestReview(2);
        productImagesPagerAdapter.setData(product.productImagesUrl);
        recentReviewAdapter.setReviews(recentReviews);
        similarProductAdapter.setProductList(similarProducts);
        variantAdapter.setData(product.variantList);

        originalPrice.setText("Rs" + String.valueOf(product.cost));
        discountedPrice.setText("Rs " + String.valueOf(product.cost)); // TODO: add field in model
        productName.setText(product.name);
        quantitySold.setText("Sold " + String.valueOf(product.itemsSold) + " items");

        productImagePager.setAdapter(productImagesPagerAdapter);
        similarProductAdapter.setOnItemClickListener(this);
        similarProductList.setAdapter(similarProductAdapter);
        variantList.setAdapter(variantAdapter);
        recentReviewList.setAdapter(recentReviewAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 2);
        LinearLayoutManager variantLayoutManager = new LinearLayoutManager(view.getContext());
        variantLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager reviewLayoutManager = new LinearLayoutManager(view.getContext());
        reviewLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        similarProductList.setLayoutManager(gridLayoutManager);
        variantList.setLayoutManager(variantLayoutManager);
        recentReviewList.setLayoutManager(reviewLayoutManager);

        // make a strike through Original Price
        originalPrice.setPaintFlags(originalPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        packageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                serviceDescriptionBottomSheet.show(getChildFragmentManager(), "Service Description");
            }
        });

        moreRatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onFragmentInteractionListener != null) {
                    ReviewsFragment fragment = ReviewsFragment.newInstance(productId);
                    onFragmentInteractionListener.onInteraction(fragment);
                }
            }
        });
    }

    @Override
    public void setOnFragmentInteractionListener(OnFragmentInteractionListener onFragmentInteractionListener) {
        this.onFragmentInteractionListener = onFragmentInteractionListener;
    }

    @Override
    public void onItemClick(int position) {
        long similarItemProductId = productViewModel.getSimilarProductList(productId).get(position).productId;
        Intent intent = new Intent(getActivity(), ProductActivity.class);
        intent.putExtra(ARG_PRODUCT_ID, similarItemProductId);
        startActivity(intent);
    }
}
